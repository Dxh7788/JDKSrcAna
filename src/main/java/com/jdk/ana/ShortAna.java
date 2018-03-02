package com.jdk.ana;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/3/2 11:38
 */
public class ShortAna {
    public static void main(String[] args) {
        //Short的机制和Integer基本一致,区别在于:
        //Short的缓冲池不能通过JVM属性配置,范围为[-128,127]
        //Short的位数为64,可以通过Size获取
        Short sht = Short.SIZE;
    }
}
