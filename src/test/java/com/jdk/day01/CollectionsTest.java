package com.jdk.day01;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * @author xh.d
 * @since 2018/8/14 13:27
 */
public class CollectionsTest {

    @Test
    public void newSetFromMapTest(){
        Set<String> exists = Collections.newSetFromMap(new HashMap<String,Boolean>());
        exists.add("kk");
        exists.add("dxh");
        System.out.println(exists);
        System.out.println(exists.isEmpty());
        System.out.println(!exists.isEmpty());
    }
}
