package org.springframework.dbeans.factory.support;

import org.springframework.dcore.io.Resource;
import org.springframework.dcore.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
        //resource用来创建上下文,doc用来解析成bean
        NodeList nodeList = doc.getChildNodes();
        for (int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if (node instanceof Element){
                Element ele = (Element) node;
                System.out.println(ele.getNodeName());
                NodeList subNodeList = ele.getChildNodes();
                for (int j=0;j<subNodeList.getLength();j++){
                    Node subNode = subNodeList.item(j);
                    if (subNode instanceof Element){
                        System.out.println(((Element)subNode).getNodeName());
                    }
                }
            }
        }
        return 0;
    }
}
