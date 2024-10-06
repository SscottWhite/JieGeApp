package com.ncstudy.listener;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class StandGuard  implements ApplicationRunner, DisposableBean {
    @Override
    public void run(ApplicationArguments args) {

       // File file = new File("/MyLog");
       // file.delete();
        System.out.println("你好。");
    }
    @Override
    public void destroy() {
        System.out.println("再见!");
    }
}