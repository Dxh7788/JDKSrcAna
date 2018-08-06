package com.jdk.reflect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xh.d
 * @since 2018/8/6 10:53
 */
public class Dlect<K,V> {
    private K name;
    private V value;

    public Dlect() {
    }

    public Dlect(K name, V value) {
        this.name = name;
        this.value = value;
    }

    public K getName() {
        return name;
    }

    public V getValue() {
        return value;
    }

    public Dlect<K,V> getMk(){
        return new Dlect() ;
    }

    public List<String> getParameterType(){
        return new ArrayList<String>(0);
    }
}
