package com.example.annotation;

import com.example.common.Constant;
import com.example.eunm.ParseRange;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JsonParse {

    /**
     * 填充范围
     * @return
     */
    ParseRange range() default ParseRange.AUTO;

    /**
     * 扫描深度
     * @return
     */
    int depth() default Constant.DEFAULT_DEPTH;

    /**
     * 是否缓存fieldName到ehcache
     * @return
     */
    boolean cache() default true;

}

