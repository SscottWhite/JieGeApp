package com.ncstudy.control;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/high")
public class HighController {

    @PostMapping("/test")
    public void test(){
        System.out.println("测试中");
    }
}
