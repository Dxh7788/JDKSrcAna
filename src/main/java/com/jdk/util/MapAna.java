package com.jdk.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 * map的原理不赘述
 * @author xh.d
 * @since 2018/3/2 16:49
 */
public class MapAna {
    public static void main(String[] args) {
        Map map = new HashMap();
        //同步map
        map = Collections.synchronizedMap(map);
        //并发map
        map = new ConcurrentHashMap();
        //排序map
        map = new LinkedHashMap();
    }
}
