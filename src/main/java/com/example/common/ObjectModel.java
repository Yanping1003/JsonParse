package com.example.common;

import com.example.annotation.JsonField;
import com.example.convert.JsonConvert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectModel {

    Method method;
    Field field;
    JsonField jsonField;
    Class<? extends JsonConvert> convert;

    public ObjectModel(){}

    public ObjectModel(Method method, Field field, JsonField jsonField, Class<? extends JsonConvert> convert) {
        this.method = method;
        this.field = field;
        this.jsonField = jsonField;
        this.convert = convert;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Class<? extends JsonConvert> getConvert() {
        return convert;
    }

    public void setConvert(Class<? extends JsonConvert> convert) {
        this.convert = convert;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public JsonField getJsonField() {
        return jsonField;
    }

    public void setJsonField(JsonField jsonField) {
        this.jsonField = jsonField;
    }
}
