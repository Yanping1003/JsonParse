package com.example.convert;

import com.example.annotation.JsonField;
import com.example.common.Constant;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConvert implements JsonConvert<LocalDate> {

    @Override
    public LocalDate convert(Field field, JsonField jsonField, String value) {
        String format = (jsonField==null|| Constant.BLANK.equals(jsonField.format()))?"yyyy-MM-dd":jsonField.format();
        return LocalDate.parse(value,DateTimeFormatter.ofPattern(format));
    }

}
