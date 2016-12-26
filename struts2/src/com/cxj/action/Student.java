package com.cxj.action;

/**
 * Created by xixi on 06/12/2016.
 */
public class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String say(){
        return "我是一个学生";
    }

}
