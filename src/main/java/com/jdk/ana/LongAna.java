package com.jdk.ana;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/3/2 11:32
 */
public class LongAna {

    public static void main(String[] args) {
        //Long的机制和Integer基本一致,区别在于:
        //Long的缓冲池不能通过JVM属性配置,范围为[-128,127]
        //没有highestOneBit和lowestOneBit方法
        //Long的位数为64,可以通过Size获取
        System.out.println(Long.SIZE);
        System.out.println(Long.highestOneBit(100));
        System.out.println(Long.valueOf(100));
    }
}
