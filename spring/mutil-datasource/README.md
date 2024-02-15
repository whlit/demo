# SpringBoot + Mybatis 多数据源

配置文件
```yaml
spring:
  datasource:
    test:
      jdbc-url: jdbc:mysql://localhost:3306/test?characterEncoding=utf-8
      username: dev
      password: 123456
      driver-class-name: com.mysql.cj.jdbc.Driver
    test2:
      jdbc-url: jdbc:mysql://localhost:3306/test2?characterEncoding=utf-8
      username: dev
      password: 123456
      driver-class-name: com.mysql.cj.jdbc.Driver
```

[数据源配置类](./md-web/src/main/java/cn/whlit/spring/md/config/DatasourceConfig.java)
创建多数据源及`SqlSessionFactory`

[DynamicDataSource](./md-web/src/main/java/cn/whlit/spring/md/config/DynamicDataSource.java)
继承`AbstractRoutingDataSource`实现方法`determineCurrentLookupKey`来获取当前数据源的key，key是在`DynamicDAtaSource`中创建
动态数据源是设置进去的
```java
@Bean("dynamicDataSource")
public DynamicDataSource dynamicDataSource(@Qualifier("testDataSource") DataSource testDataSource,
                                           @Qualifier("test2DataSource") DataSource test2DataSource) {
    Map<Object, Object> dataSourceMap = new HashMap<>();
    dataSourceMap.put("test", testDataSource);
    dataSourceMap.put("test2", test2DataSource);
    DynamicDataSource dynamicDataSource = new DynamicDataSource();
    dynamicDataSource.setTargetDataSources(dataSourceMap);
    return dynamicDataSource;
}
```

```java
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        //获取动态数据源的key，DataSourceHolder中的值是线程安全的
        return DataSourceHolder.getDataSource();
    }
}
```

