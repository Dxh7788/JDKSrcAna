package com.jdk.reflect;

/**
 * @author xh.d
 * @since 2018/8/6 13:03
 */
public class User extends Person<User> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
