package com.whlit.mybatis;

import java.lang.reflect.*;
import java.sql.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SqlSession {

    private final String url = "jdbc:mysql://localhost:3306/test";
    private final String username = "dev";
    private final String password = "123456";

    private Map<Class<?>, Object> mappers = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> clazz) {
        if (mappers.get(clazz) != null) {
            return (T) mappers.get(clazz);
        }
        List<String> methods = Arrays.stream(clazz.getDeclaredMethods()).map(Method::getName).toList();
        Object obj = new Object();
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                if (methods.contains(methodName)) {
                    return invokeSelect(proxy, method, args);
                }
                return method.invoke(obj, args);
            }
        });
    }

    private Object invokeSelect(Object proxy, Method method, Object[] args) throws Exception {

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            StringBuilder sb = new StringBuilder();
            sb.append("select ");
            String columns = getColumns(method);
            sb.append(columns);
            sb.append(" from ");
            sb.append(method.getAnnotation(Table.class).value());
            sb.append(" where ");
            String where = getConditions(method);
            sb.append(where);
            // select id, name, age from item where id = ? and name = ?
            String sql = sb.toString();
            System.out.println(sql);
            PreparedStatement statement = connection.prepareStatement(sql);
            setArgs(args, statement);
            ResultSet resultSet = statement.executeQuery();

            Class<?> returnType = method.getReturnType();
            List<Object> results = getResults(resultSet, returnType);

            if (!results.isEmpty()) {
                return results.getFirst();
            }
        }

        return null;
    }

    private static List<Object> getResults(ResultSet resultSet, Class<?> type) throws SQLException {
        Field[] fields = type.getDeclaredFields();
        Method[] methods = type.getMethods();
        Map<String, Method> methodMap = Arrays.stream(methods)
                .collect(Collectors.toMap(method1 -> method1.getName().toLowerCase(), Function.identity(), (v1, v2) -> v1));
        List<Object> results = new ArrayList<>();
        while (resultSet.next()) {
            Object res = null;
            try {
                res = type.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            for (Field field : fields) {
                Object fieldValue = null;
                if (field.getType().equals(Integer.class)) {
                    fieldValue = resultSet.getInt(field.getName());
                } else if (field.getType().equals(Long.class)){
                    fieldValue = resultSet.getLong(field.getName());
                }else if (field.getType().equals(String.class)) {
                    fieldValue = resultSet.getString(field.getName());
                }
                Method setMethod = methodMap.get("set" + field.getName().toLowerCase());
                if (setMethod != null) {
                    try {
                        setMethod.invoke(res, fieldValue);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            results.add(res);
        }
        return results;
    }

    private static void setArgs(Object[] args, PreparedStatement statement) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (arg instanceof String) {
                statement.setString(i + 1, arg.toString());
            }else if (arg instanceof Integer) {
                statement.setInt(i + 1, (Integer) arg);
            }else if (arg instanceof Long) {
                statement.setLong(i + 1, (Long) arg);
            }
        }
    }

    private static String getConditions(Method method) {
        Parameter[] parameters = method.getParameters();
        String where = Arrays.stream(parameters).map(parameter -> parameter.getAnnotation(Param.class).value() + " = ?").collect(Collectors.joining(" and "));
        return where;
    }

    private String getColumns(Method method) {
        Class<?> returnType = method.getReturnType();
        return Arrays.stream(returnType.getDeclaredFields()).map(Field::getName).collect(Collectors.joining(","));
    }

}
