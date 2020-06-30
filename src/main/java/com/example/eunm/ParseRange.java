package com.example.eunm;

public enum ParseRange {

    /**
     * AUTO 将填充实体中所有属性(JsonField除外)：
     * 1、含有@JsonField注解，将去匹配JsonField.value,如果JsonField.value==""则自动取FieldName
     * 2、不含有@JsonField注解，直接自动取FieldName
     */
    AUTO,

    /**
     * ONLY_JSON_PARSE 只填充实体中含@JsonField注解的属性：
     * 1、含有@JsonField注解，将去匹配JsonField.value,如果JsonField.value==""则自动取FieldName
     */
    ONLY_JSON_PARSE

}
