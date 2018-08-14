package com.jdk.day02;

import org.junit.Test;
import org.springframework.dbeans.factory.support.XmlBeanDefinitionReader;
import org.springframework.dcore.io.DefaultResourceLoader;

/**
 * @author xh.d
 * @since 2018/8/14 11:54
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void parse(){
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(resourceLoader);
        reader.loadBeanDefinitions("/test_books.xml");
    }
}
