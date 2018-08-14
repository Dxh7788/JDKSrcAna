package org.springframework.dbeans.factory.support;

import org.springframework.dcore.io.Resource;
import org.springframework.dcore.io.ResourceLoader;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xh.d
 * @since 2018/8/14 11:11
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        InputStream inputStream = resource.getInputStream();
        InputSource inputSource = new InputSource(inputStream);

        return doLoadBeanDefinitions(inputSource,resource);
    }

    protected int doLoadBeanDefinitions(InputSource is, Resource resource) {
        //加载Docment,没有设置validate,EntityHandler,ErrorHandler等
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setValidating(false);
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(is);
            //开始解析Bean
            int count = registerBeanDefinitions(doc,resource);
            return count;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int registerBeanDefinitions(Document doc, Resource resource) {
        return 0;
    }
}
