package com.jdk.day01;

import org.junit.Test;

/**
 * @author xh.d
 * @since 2018/8/13 17:17
 */
public class StringUtilsTest {

    @Test
    public void formatTest(){
        String name = "ddd";
        String pwd = "123abc";
        System.out.println(String.format("%s-%s",name,pwd));
    }
}
