package com.jdk.data;

import com.jdk.util.LinkMap;
import org.junit.Test;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/3/2 15:23
 */
public class LinkMapTest {
    @Test
    public void test(){
        LinkMap head = new LinkMap();
        head.push(Integer.valueOf(5));
        head.push(Integer.valueOf(6));
        head.push(Integer.valueOf(7));
        System.out.println(head.pop());
        System.out.println(head.size());
    }
}
