package com.jdk.reflect;

import org.junit.Test;

import java.lang.reflect.*;

/**
 * TypeVariable代表的是泛型变量/ParameterizedType代表泛型/GenericArrayType代表泛型数组
 * @author xh.d
 * @since 2018/8/6 10:55
 */
public class RefectTest {

    @Test
    public void reflectTest() throws NoSuchMethodException {
        Dlect<String,String> dlect = new Dlect<String, String>("name","ddd");

        Method method = dlect.getClass().getMethod("getMk");
        Type type = method.getGenericReturnType();
        if (type instanceof ParameterizedType){
            System.out.println("泛型参数...");
        }else if (type instanceof TypeVariable){
            System.out.println("参数化参数");
        }else if (type instanceof GenericArrayType){
            System.out.println("泛型数组");
        }
        Common common = new Common();
        Method[] methods = common.getClass().getDeclaredMethods();
        for (Method method1:methods) {
            Type type1 = method1.getGenericReturnType();
            if (type1 instanceof ParameterizedType) {
                System.out.println("泛型参数...");
            } else if (type1 instanceof TypeVariable) {
                System.out.println("参数化参数");
            } else if (type1 instanceof GenericArrayType) {
                System.out.println("泛型数组");
            }
        }
    }
}
