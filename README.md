# JsonParse
个人使用，Json转VO实体
调试启动类：com.example.util.GsonUtil

## 注解说明
#### @JsonParse 添加在类上，表示整个实体和Json映射控制
    range：属性映射范围 1、AUTO自动识别，自动映射 2、ONLY_JSON_PARSE仅映射添加了@JsonField注解的属性
#### @JsonField：添加在属性上，表示字段映射键值对
    value：对应Json中的key
    format：数据格式化
    convert：数据转换类
#### @IgnoreField：添加在属性上，表示忽略字段，即使Json有对应的数据也不会填充