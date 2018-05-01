package com.models;

import java.io.Serializable;

public class AuthUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private String fullname;
    private String mobile;
    private int type;


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "fullname='" + fullname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type=" + type +
                '}';
    }
}
