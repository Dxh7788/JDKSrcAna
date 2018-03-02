package com.jdk.ana;

/**
 * 整型分析
 * @author xh.d
 * @since 2018/3/2 9:48
 */
public class IntegerAna {

    public static void main(String[] args) {
        /**
         * 首先看一下,Integer的docstring
         * Integer 类使用对象封装一个基本类型int数据,也就是把int转为Integer类.
         * Integer 类提供了方法把int转化为String,也可以把String转换为int,和处理int时有用的常量和方法.
         * public static final Class<Integer>  TYPE = (Class<Integer>) Class.getPrimitiveClass("int")
         * Integer的MIN_VALUE,MAX_VALUE代表[-2的31次方]
         * */
        //先转化为某一进制,然后输出为字符串
        System.out.println(Integer.toString(-10, 4));
        //Integer对象除了不能直接转化为char、boolean外,可以转化为long、int、byte、short、float、double
        Integer num = new Integer(10);
        System.out.println(""+num.byteValue()+" ,"+ num.intValue() +" ,"+ num.longValue() +" ,"+num.shortValue() +" ,"+ num.floatValue()+" ,"+ num.doubleValue());
        /**
         * Integer的静态方法
         */
        //int转化为Integer
        Integer iv0 =Integer.valueOf(10);
        Integer iv1 = new Integer(10);
        //auto boxing
        Integer iv3 = 10; //equal to Integer.valueOf(10),same instance
        System.out.println(iv0 == iv1);
        System.out.println(iv0 == iv3);
        //有String作为参数Integer构造器
        Integer is0 = Integer.valueOf("7");
        Integer is1 = new Integer("5");
        Integer is2 = Integer.valueOf("5");
        System.out.println(is0 == is1);
        System.out.println(is0 == is2);
        //bitCount返回数字中1的个数
        System.out.println(Integer.bitCount(is0));
        //将String转化为10进制数
        System.out.println(Integer.decode("0x10"));
        //如果配置property值则使用property值,如果没有则使用默认值.这里property为kl.ol,默认值为5
        System.out.println(Integer.getInteger("kl.ol", 5));
        //highestOneBit最高位1的权值,lowestOneBit最低位1位的权值
        System.out.println(Integer.highestOneBit(8));
        System.out.println(Integer.lowestOneBit(4));
        //返回符号值
        System.out.println(Integer.signum(0));

    }
}
