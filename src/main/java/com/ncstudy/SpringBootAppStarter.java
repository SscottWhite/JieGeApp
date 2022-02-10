package com.ncstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//启动页放在static 静态资源包里
@SpringBootApplication
public class SpringBootAppStarter {
  public static void main( String[] args ) {
      SpringApplication.run(SpringBootAppStarter.class, args);
  }
}
