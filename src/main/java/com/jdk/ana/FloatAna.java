package com.jdk.ana;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/3/2 11:44
 */
public class FloatAna {
    public static void main(String[] args) {
        //Float是没有缓存的,Float的valueOf是为了保持开发习惯而做的,和整型使用缓存是不一样的.
        Float ft0 = Float.valueOf(2.3f);
        Float ft1 = new Float(2.3f);

        Float positiveInfinity = Float.POSITIVE_INFINITY;
        if (ft0.floatValue() < positiveInfinity.floatValue()){
            System.out.println("小于无穷值");
        }
        System.out.println(ft0 == ft1);
    }
}
