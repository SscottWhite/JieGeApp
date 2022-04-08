package com.ncstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.ncstudy.mapper") //扫描的mapper
@EnableSwagger2
@SpringBootApplication
//(exclude = SecurityAutoConfiguration.class)
@ServletComponentScan("com.ncstudy.servlet")
@EnableConfigurationProperties
public class SpringBootAppStarter {
  public static void main( String[] args ) {
      SpringApplication.run(SpringBootAppStarter.class, args);
  }
}
