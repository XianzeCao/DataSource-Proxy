package com.zaccao.datasourceproxy.proxy.annotation;

import com.zaccao.datasourceproxy.proxy.DataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInfo;
import org.springframework.beans.BeanUtils;

import javax.sql.DataSource;
import java.lang.reflect.Method;


@Slf4j
public class AutoDataSourceProxyAdvice implements MethodInterceptor, IntroductionInfo {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("自动代理数据源");
        DataSourceProxy dataSourceProxy = DataSourceProxyHolder.get().putDataSource((DataSource) invocation.getThis());
        Method method = invocation.getMethod();
        Object[] args = invocation.getArguments();
        Method m = BeanUtils.findDeclaredMethod(DataSourceProxy.class, method.getName(), method.getParameterTypes());
        if (m != null) {
            return m.invoke(dataSourceProxy, args);
        } else {
            return invocation.proceed();
        }
    }

    @Override
    public Class<?>[] getInterfaces() {
        return new Class[]{SensiveProxy.class};
    }

}
