package com.jdk.data;

import com.jdk.util.DMap;
import org.junit.Test;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/3/2 16:03
 */
public class DMapTest {
    @Test
    public void test(){
        DMap dMap = new DMap();
        dMap.put(10, 10);
        dMap.put(11, 11);
        dMap.put(12, 12);

        System.out.println(dMap.get(12));
    }
}
