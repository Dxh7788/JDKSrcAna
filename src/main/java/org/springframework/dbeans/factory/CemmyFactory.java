package org.springframework.dbeans.factory;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/8/13 15:23
 */
public class CemmyFactory implements FactoryBean<Object>,InitializingBean,BeanNameAware,BeanFactoryAware,DisposableBean {

    public Object getObject() throws Exception {
        return null;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }

    public void afterPropertiesSet() {

    }

    public void destory() {

    }
}
