package com.ncstudy.config.datasourceconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

//@Configuration
public class MyDataSourceConfig {
 
  //  @Bean("dataSourceOne")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DruidDataSource dataSourceOne(){
        return new DruidDataSource();
    }
 

 
}
