package com.jdk.ana;

import static java.lang.Boolean.TRUE;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by JDKSrcAna
 *
 * @author xh.d
 * @since 2018/3/2 11:17
 */
public class BooleanAna {

    public static void main(String[] args) {
        Boolean b0 = true;//autoboxing by return Boolean.true
        Boolean b1 = new Boolean(true);
        Boolean b2 = TRUE;
        Boolean b3 = Boolean.valueOf(true);

        System.out.println(b0 == b2==b3);
        System.out.println(b0 == b1);
        System.out.println(b0 == b3);
        System.out.println(b1 == b3);
    }
}
