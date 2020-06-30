package com.example.vo;

import com.example.annotation.JsonField;
import com.example.convert.DateConvert;

import java.time.LocalDate;

public class UserVo {

    @JsonField("usernam1e")
    String username;
    String idCard;
    String sex;
    @JsonField(value = "birth11",convert = DateConvert.class,format = "yyyy-MM-dd HH:mm:ss")
    LocalDate birth;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "username='" + username + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                '}';
    }
}
