package com.jdk.ana;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/3/2 11:27
 */
public class ByteAna {

    public static void main(String[] args) {
        //Byte的机制和Integer基本一致,区别在于:
        //Byte的缓冲池不能通过JVM属性配置,范围为[-128,127]
        //没有highestOneBit和lowestOneBit方法
        //Byte的位数为8,可以通过Size获取
        System.out.println(Byte.SIZE);
    }
}
