package com.jdk.main;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

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
        InputStream inputStream = c1.getResourceAsStream("META-INF/anioj.handlers");
        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties.size());
    }

    public static void main(String[] args) throws IOException {
        new Loader().load();
    }
}
