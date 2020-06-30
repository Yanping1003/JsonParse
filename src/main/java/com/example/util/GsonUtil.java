package com.example.util;

import com.example.annotation.JsonParse;
import com.example.common.ObjectModel;
import com.example.convert.JsonConvert;
import com.example.vo.UserVo;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class GsonUtil {

    private AnalysisObject analysisObject = new AnalysisObject();
    private Map<Class<? extends JsonConvert>,JsonConvert> convertMap = new HashMap<Class<? extends JsonConvert>,JsonConvert>();

    public <T> T setValue(JsonObject jsonObject,Class<T> targetClass,T targetObject) throws Exception{
        JsonParse jsonParse = targetClass.getAnnotation(JsonParse.class);
        int depth = jsonParse==null?3:jsonParse.depth();
        Map<String, ObjectModel> methodMap = analysisObject.analysisAllSetMethod(targetClass, jsonParse);
        return setValue(jsonObject,methodMap,targetClass,targetObject);
    }

    private <T> T setValue(JsonObject jsonObject,Map<String, ObjectModel> methodMap,Class<T> targetClass,T targetObject) throws Exception{
        JsonConvert jsonConvert = null;
        ObjectModel objectModel = null;
        String value = null;
        Object valueObject = null;
        for (String key:methodMap.keySet()) {
            if(jsonObject.has(key)){
                objectModel = methodMap.get(key);
                jsonConvert = convertMap.get(objectModel.getConvert());
                if(jsonConvert==null){
                    jsonConvert=methodMap.get(key).getConvert().newInstance();
                    convertMap.put(objectModel.getConvert(),jsonConvert);
                }
                value = jsonObject.get(key).getAsString();
                valueObject = jsonConvert.convert(objectModel.getField(),objectModel.getJsonField(),value);
                targetObject = analysisObject.invokeMethod(targetClass,targetObject,objectModel.getMethod(),valueObject);
            }
        }
        return targetObject;
    }

    public static void main(String[] args) throws Exception {
        String jsonstr = "{\n" +
                "    \"usernam1e\": \"哈哈\",\n" +
                "    \"idCard\": \"3645454\",\n" +
                "    \"birth11\": \"1993-08-18 12:15:33\",\n" +
                "    \"sex\": \"1\",\n" +
                "    \"age\": 18\n" +
                "  }";
        JsonObject jsonObject = new JsonParser().parse(jsonstr).getAsJsonObject();
        GsonUtil gsonUtil = new GsonUtil();
        UserVo userVo = gsonUtil.setValue(jsonObject, UserVo.class,null);
        System.out.println(userVo.toString());
    }

}
