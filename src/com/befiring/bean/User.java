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
    public String password;

    public User() {
    }

    public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

  


}
