package com.ncstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.ncstudy.mapper") //扫描的mapper
@EnableSwagger2
@SpringBootApplication
public class SpringBootAppStarter {
  public static void main( String[] args ) {
      SpringApplication.run(SpringBootAppStarter.class, args);
  }
}
