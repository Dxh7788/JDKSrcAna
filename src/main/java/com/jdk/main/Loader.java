package com.jdk.main;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author xh.d
 * @since 2018/8/15 10:30
 */
public class Loader {
    public void load() throws IOException {
        ClassLoader c1 = null;
        if (c1==null){
            c1 = Thread.currentThread().getContextClassLoader();
            if (c1==null){
                c1=Loader.class.getClassLoader();
                if (c1 == null){
                    c1 = ClassLoader.getSystemClassLoader();
                }
            }
        }
        //getResources会找到所有以name结尾的文件,是全局搜索
        Enumeration<URL> resources = c1.getResources("META-INF/anioj.handlers");
        int count = 0;
        while (resources.hasMoreElements()){
            count++;
            URL url = resources.nextElement();
            System.out.println(url.getFile());
        }
        System.out.println("共有"+count+"个元素!!!");
    }

    public static void main(String[] args) throws IOException {
        new Loader().load();
    }
}
