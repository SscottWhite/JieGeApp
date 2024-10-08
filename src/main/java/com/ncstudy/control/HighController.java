package com.ncstudy.control;

import com.aliyun.dingtalkoauth2_1_0.Client;
import com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenRequest;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
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
