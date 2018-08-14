2018-08-14 Spring解析XML配置
    Spring读取XML最后将BeanDefinition放入容器的过程分为两步.
    (1)读取XML配置,形成BeanDefinition
    (2)将BeanDefinition放入容器中.
    其中第一步中要保存一个上下文用来存储将来用于保存BeanDefinition的注册器BeanRegistry.下面来单独分析这两个步骤.
读取XML配置的Reader类是XmlBeanDefinitionReader
1.加载Document