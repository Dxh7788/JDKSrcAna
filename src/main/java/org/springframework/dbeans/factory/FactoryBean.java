package org.springframework.dbeans.factory;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/8/13 15:19
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;
    Class<?> getObjectType();
    boolean isSingleton();
}
