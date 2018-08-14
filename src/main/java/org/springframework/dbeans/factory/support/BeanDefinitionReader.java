package org.springframework.dbeans.factory.support;
import org.springframework.dcore.io.Resource;
import org.springframework.dcore.io.ResourceLoader;
/**
 * @author xh.d
 * @since 2018/8/14 10:03
 */
public interface BeanDefinitionReader {

    ResourceLoader getResourceLoader();

    ClassLoader getBeanClassLoader();

    int loadBeanDefinitions(String location);

    int loadBeanDefinitions(Resource resource);
}
