package com.example.util;

import com.example.annotation.IgnoreField;
import com.example.annotation.JsonField;
import com.example.annotation.JsonParse;
import com.example.common.ObjectModel;
import com.example.convert.JsonConvert;
import com.example.convert.PrimitiveConvert;
import com.example.eunm.ParseRange;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnalysisObject {

    public Map<String, ObjectModel> analysisAllSetMethod(Class<?> tClass, JsonParse jsonParse) throws NoSuchMethodException {
        Map<String,ObjectModel> fieldMap = null;
        Field[] declaredFields = tClass.getDeclaredFields();
        if(declaredFields!=null&&declaredFields.length>0){
            String key = null;
            int len = declaredFields.length;
            ObjectModel objectModel = null;
            ParseRange range = (jsonParse==null)?ParseRange.AUTO:jsonParse.range();
            fieldMap = new LinkedHashMap<String,ObjectModel>();
            for (Field field:declaredFields) {
                if(field.getAnnotation(IgnoreField.class)!=null)continue;
                JsonField jsonField = field.getAnnotation(JsonField.class);
                if(jsonField!=null){
                    key = jsonField.value();
                    if(JsonConvert.BLANK.equals(key))key=field.getName();
//                    key = key.toUpperCase();
                    objectModel = new ObjectModel(tClass.getMethod(String.format("set%s",toUpperCaseFirst(field.getName())),field.getType()),field,jsonField,jsonField.convert());
                    fieldMap.put(key,objectModel);
                }else if(range==ParseRange.AUTO){
                    key=field.getName();
//                    key = key.toUpperCase();
                    objectModel = new ObjectModel(tClass.getMethod(String.format("set%s",toUpperCaseFirst(field.getName())),field.getType()),field,jsonField, PrimitiveConvert.class);
                    fieldMap.put(key,objectModel);
                }else{
                    //other's not put
                }
            }
        }
        return fieldMap;
    }

    public <T> T invokeMethod(Class<T> targetClass,T targetObject,Method method,Object value) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        targetObject = targetObject==null?targetClass.newInstance():targetObject;
        method.invoke(targetObject,value);
        return targetObject;
    }

    private String toUpperCaseFirst(String s){
        return s.substring(0,1).toUpperCase()+s.substring(1);
    }

}
