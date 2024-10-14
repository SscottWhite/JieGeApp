package com.ncstudy.control;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/high")
public class HighController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("测试中");
        return "hello world";
    }
}
