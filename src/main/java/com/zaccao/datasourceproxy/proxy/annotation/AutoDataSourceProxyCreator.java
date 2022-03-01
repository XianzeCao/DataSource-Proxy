package com.zaccao.datasourceproxy.proxy.annotation;

import org.springframework.aop.Advisor;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.beans.BeansException;

import javax.sql.DataSource;


public class AutoDataSourceProxyCreator extends AbstractAutoProxyCreator {

    private final Advisor advisor = new DefaultIntroductionAdvisor(new AutoDataSourceProxyAdvice());

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> aClass, String beanName, TargetSource targetSource) throws BeansException {
        return new Object[]{advisor};
    }

    //重写shouldSkip,只有针对DataSource这个类的加载时需要增加切面来增强
    @Override
    protected boolean shouldSkip(Class<?> beanClass, String beanName) {
        return SensiveProxy.class.isAssignableFrom(beanClass) ||
                !DataSource.class.isAssignableFrom(beanClass);
    }
}
