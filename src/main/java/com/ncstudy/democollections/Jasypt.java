package com.ncstudy.democollections;


import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Jasypt {

    @Autowired
    private StringEncryptor stringEncryptor;

    @GetMapping("/jasypt")
    @ResponseBody
    public void test(){
        System.out.println("加密后的MySQL账号：" + stringEncryptor.encrypt("root"));
        System.out.println("加密后的MySQL密码：" + stringEncryptor.encrypt("wiska123"));
        System.out.println("加密后的MySQLURL：" + stringEncryptor.encrypt("jdbc:mysql://8.153.38.18:3310/JieGeApp?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false"));
    }
}
