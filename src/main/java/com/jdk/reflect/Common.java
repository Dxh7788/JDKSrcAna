package com.jdk.reflect;

import java.util.Collection;
import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/8/6 12:12
 */
public class Common<T extends Collection> {


    public Common<List> getCommon(){
        return new Common<List>();
    }
}
