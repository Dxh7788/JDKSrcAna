package com.jdk;

/**
 * @author xh.d
 * @since 2018/8/15 12:56
 */
public abstract class BaseClass implements BaseInterface {
    @Override
    public void vbn(String name) {
        System.out.println(">>>>加载的类名称是:"+name+"....");
    }
}
