package org.springframework.dbeans.factory.support;

import org.springframework.dcore.io.DefaultResourceLoader;
import org.springframework.dcore.io.Resource;
import org.springframework.dcore.io.ResourceLoader;

/**
 * @author xh.d
 * @since 2018/8/14 10:50
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private ResourceLoader resourceLoader;

    private ClassLoader beanClassLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return null;
    }

    public ClassLoader getBeanClassLoader() {
        return null;
    }

    public int loadBeanDefinitions(String location) {
        return loadBeanDefinitions(resourceLoader.getResource(location));
    }

    public int loadBeanDefinitions(Resource resource) {
        return 0;
    }
}
