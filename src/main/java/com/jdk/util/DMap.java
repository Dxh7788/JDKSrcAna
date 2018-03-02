package com.jdk.util;

import com.jdk.util.LinkMap;



/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/3/2 15:49
 */
public class DMap {
    private int capacity = 16;
    private LinkMap[] linkMaps = new LinkMap[capacity];
    private int curPos;

    public DMap() {
        for (int i=0; i!=capacity ;i++){
            linkMaps[i] = new LinkMap();
        }
    }

    public void put(Integer key, Integer value){
        if (curPos<16){
            int index = index(key);
            linkMaps[index].push(value);
        }
    }

    private int index(Integer key) {
        return key%capacity;
    }

    public Integer get(Integer key){
        return linkMaps[index(key)].pop();
    }
}
