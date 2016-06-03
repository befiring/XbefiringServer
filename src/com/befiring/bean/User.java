package com.befiring.bean;


import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/3.
 */
public class User implements Serializable{

    /**
	 * 
	 */
	public String name;
    public int age;
    public int sex;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


}
