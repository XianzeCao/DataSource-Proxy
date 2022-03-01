package com.zaccao.datasourceproxy;

import com.zaccao.datasourceproxy.proxy.annotation.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoDataSourceProxy
@SpringBootApplication
public class DataSourceProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSourceProxyApplication.class, args);
    }

}
