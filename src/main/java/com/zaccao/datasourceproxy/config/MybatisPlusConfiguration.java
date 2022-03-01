package com.zaccao.datasourceproxy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@MapperScan(basePackages = "com.zaccao.datasourceproxy.dal.mapper")
@EnableTransactionManagement
public class MybatisPlusConfiguration {
}
