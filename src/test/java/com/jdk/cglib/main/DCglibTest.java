package com.jdk.cglib.main;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * @author xh.d
 * @since 2018/8/13 14:12
 */
public class DCglibTest {

    @Test
    public void test1(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DCglibProvider.class);
        enhancer.setCallback(new DCglibInterceptor(){

        });
        DCglibProvider provider = (DCglibProvider)enhancer.create();
        provider.pry("name");
    }
}
