package com.jdk.main;

import com.jdk.BaseClass;
import com.jdk.BaseInterface;
import com.jdk.DefaultBaseClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

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
        Properties props = new Properties();
        while (resources.hasMoreElements()){
            count++;
            URL url = resources.nextElement();
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            props.load(is);
            System.out.println(url.getFile());
        }
        Set<Object> keys = props.keySet();
        for (Object key:keys){
            String keyStr = String.valueOf(key);
            Object value = props.getProperty(keyStr);
            if (value==null){
                System.out.println(">>>>>>不存在....");
            }else if (value instanceof BaseInterface){
                BaseInterface baseInterface = (BaseInterface) value;
            }else {
                String className = String.valueOf(value);
                try {
                    Class<?> clazz = Class.forName(className);
                    BaseInterface baseInterface = (BaseInterface) clazz.newInstance();
                    baseInterface.vbn(className);
                }catch (ClassNotFoundException e){
                    System.out.println(">>>>>>找不到类:"+className+"....");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Loader loader = new Loader();
        loader.load();
        loader.checkInstanceOf();

    }

    public void checkInstanceOf(){
        DefaultBaseClass baseClass =new DefaultBaseClass();
        if (baseClass instanceof BaseClass){
            System.out.println("instanceof abstract true");
        }
        if (baseClass instanceof BaseInterface){
            System.out.println("instanceof Interface true");
        }
    }
}
