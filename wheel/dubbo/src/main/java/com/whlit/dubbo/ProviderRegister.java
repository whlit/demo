package com.whlit.dubbo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProviderRegister {

    private Map<String, Object> services = new HashMap<>();
    private Map<String, Map<String, Method>> methods = new HashMap<>();

    public <T> void register(Class<T> serviceInterface, T provider) {
        String serviceName = serviceInterface.getName();
        services.put(serviceName, provider);
        Method[] declaredMethods = serviceInterface.getDeclaredMethods();
        methods.put(serviceName, new HashMap<>());
        for (Method declaredMethod : declaredMethods) {
            String methodName = declaredMethod.getName();
            methods.get(serviceName).put(methodName, declaredMethod);
        }
    }

    public Object invoke(RequestMessage message) throws Exception {
        Object o = services.get(message.getService());
        Method method = methods.get(message.getService()).get(message.getMethod());
        return method.invoke(o, message.getArgs());
    }

}
