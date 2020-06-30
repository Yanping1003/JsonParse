package com.example.convert;

import com.example.annotation.JsonField;
import com.example.common.Constant;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class PrimitiveConvert implements JsonConvert<Object> {

    Map<Class<?>,Integer> primitiveMap = new HashMap<Class<?>,Integer>();

    public PrimitiveConvert(){
        //byte、short、int、long、boolean、char、float、double
        primitiveMap.put(String.class,0);
        primitiveMap.put(byte.class,1);
        primitiveMap.put(Byte.class,1);
        primitiveMap.put(short.class,2);
        primitiveMap.put(Short.class,2);
        primitiveMap.put(int.class,3);
        primitiveMap.put(Integer.class,3);
        primitiveMap.put(long.class,4);
        primitiveMap.put(Long.class,4);
        primitiveMap.put(boolean.class,5);
        primitiveMap.put(Boolean.class,5);
        primitiveMap.put(char.class,6);
        primitiveMap.put(Character.class,6);
        primitiveMap.put(float.class,7);
        primitiveMap.put(Float.class,7);
        primitiveMap.put(double.class,8);
        primitiveMap.put(Double.class,8);
    }

    @Override
    public Object convert(Field field, JsonField jsonField, String value) {
        if(primitiveMap.containsKey(field.getType())){
            Object vObject = valueOf(field.getType(),value);
            String format = jsonField==null? Constant.BLANK:jsonField.format();
            if(!Constant.BLANK.equals(format)){
                return String.format(format,vObject);
            }else {
                return vObject;
            }
        }
        return null;
    }

    private Object valueOf(Class<?> tClass,String value){
        Object returnValue = null;
        switch (primitiveMap.get(tClass)){
            case 0:returnValue=value;break;
            case 1:returnValue=Byte.valueOf(value);break;
            case 2:returnValue=Short.valueOf(value);break;
            case 3:returnValue=Integer.valueOf(value);break;
            case 4:returnValue=Long.valueOf(value);break;
            case 5:
                value="1".equals(value)?"true":value;
                returnValue=Boolean.valueOf(value);
                break;
            case 6:returnValue=value.charAt(0);break;
            case 7:returnValue=Float.valueOf(value);break;
            case 8:returnValue=Double.valueOf(value);break;
        }
        return returnValue;
    }

}
