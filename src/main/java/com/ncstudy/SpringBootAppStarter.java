package com.ncstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.ncstudy.mapper")  //扫描的mapper,因为mapper是mybatis的, 而@Repposity是spring自带的
@EnableSwagger2                    //开启swagger
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)  //这才是正确的
                                   //(exclude={DruidDataSourceAutoConfigure.class,DataSourceAutoConfiguration.class})
@ServletComponentScan("com.ncstudy.config.servletconfig")
@EnableConfigurationProperties     //使@ConfigurationProperties(prefix = "xxx")注解的类生效
public class SpringBootAppStarter { //extends SpringBootServletInitializer {
  public static void main( String[] args )
  {
      SpringApplication springApplication = new SpringApplication(SpringBootAppStarter.class);
      springApplication.run(args);
  }

    // @Override
    // protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    //     return builder.sources(this.getClass());
    // }
}
