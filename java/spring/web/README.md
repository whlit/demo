# web

## Spring boot 读取yaml配置文件

### 读取对象集合

```yaml
admin:
  users:
    -
      id: 1
      name: '张三'
    -
      id: 2
      name: '李四'
```

`@Value`这个注解是解析不了上面的这种情况的，`@Value` 一般用于直接注入特定的属性值，也就是直接通过`key: value` 
的方式解析数据，value的类型一般是基本的数据类型、字符串、List、Map，而上面的这种`List<User>` 或者`List<Map>` 
这种形式的就不可以了

`@ConfigurationProperties` 这个注解一般用于将多个对象绑定到特定的对象，例如`List<User>` 或者`List<Map>`
这种的