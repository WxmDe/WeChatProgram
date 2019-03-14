package com.example.domain;

import java.util.Calendar;
import java.util.Date;

/**
 * @Decription TODO
 * @Author wxm
 * @Date 2019/3/6 16:02
 **/
public class Person {

    private String name;
    private Calendar birth;
    private String relative;//关系

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBirth() {
        return birth;
    }

    public void setBirth(Calendar birth) {
        this.birth = birth;
    }

    public String getRelative() {
        return relative;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }
}
