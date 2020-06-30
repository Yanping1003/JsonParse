package com.example.annotation;

import com.example.common.Constant;
import com.example.convert.JsonConvert;
import com.example.convert.PrimitiveConvert;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonField {

    /**
     * 映射的属性别名，如果为""则自动填充为FieldName
     * @return
     */
    String value() default Constant.BLANK;

//    /**
//     * 默认值，只有在映射失败时使用
//     * @return
//     */
//    String example();

    /**
     * 格式化
     * @return
     */
    String format() default Constant.BLANK;

    /**
     * 转换类
     * @return
     */
    Class<? extends JsonConvert> convert() default PrimitiveConvert.class;

}
