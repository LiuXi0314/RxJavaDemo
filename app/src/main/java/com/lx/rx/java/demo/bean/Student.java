package com.lx.rx.java.demo.bean;

/**
 * Created on 17-7-31 上午10:46
 */

public class Student {

    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + ", sex='" + sex + '}';
    }
}
