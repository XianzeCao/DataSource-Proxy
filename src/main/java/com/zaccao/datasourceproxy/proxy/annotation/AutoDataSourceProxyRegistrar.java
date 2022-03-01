package com.zaccao.datasourceproxy.proxy.annotation;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


public class AutoDataSourceProxyRegistrar implements ImportBeanDefinitionRegistrar {

    public static final String BEAN_NAME_AUTO_DATA_SOURCE_PROXY_CREATOR = "autoDataSourceProxyCreator";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (!registry.containsBeanDefinition(BEAN_NAME_AUTO_DATA_SOURCE_PROXY_CREATOR)) {
            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
                    .genericBeanDefinition(AutoDataSourceProxyCreator.class)
                    .getBeanDefinition();
            registry.registerBeanDefinition(BEAN_NAME_AUTO_DATA_SOURCE_PROXY_CREATOR, beanDefinition);
        }
    }
}
