package com.zaccao.datasourceproxy.proxy.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoDataSourceProxyRegistrar.class)
@Documented
public @interface EnableAutoDataSourceProxy {
}
