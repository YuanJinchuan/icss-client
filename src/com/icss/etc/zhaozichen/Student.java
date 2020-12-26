package com.icss.etc.zhaozichen;

import java.io.Serializable;

/**
 * @title:
 * @fileName: ${fileName}
 * @description:
 * @copyright:
 * @company: 个人
 * @author: 原晋川
 * @date: 2020/12/26 11:05
 * @version: V1.0
 */
public class Student implements Serializable {

    private String id;

    private String type;

    private String name;

    private String age;

    private String day;

    public Student(String id, String type, String name, String age, String day) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
