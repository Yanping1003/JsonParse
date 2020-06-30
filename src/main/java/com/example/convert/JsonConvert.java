package com.example.convert;

import com.example.annotation.JsonField;

import java.lang.reflect.Field;

public interface JsonConvert<T> {

    T convert(Field field, JsonField jsonField, String value);

}
