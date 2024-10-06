package com.ncstudy.control;

import com.aliyun.dingtalkoauth2_1_0.Client;
import com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenRequest;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.ncstudy.DingDing.GetAccessToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/high")
public class HighController {

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("测试中");
        return "hello world";
    }

    @GetMapping("/testDD")
    @ResponseBody
    public String testDD() throws Exception {
        Config config = new Config();
        config.protocol = "https";
        config.regionId = "central";
        Client client = new Client(config);
        GetAccessTokenRequest getAccessTokenRequest = new GetAccessTokenRequest()
                .setAppKey("dingk0yju79vn6jqlljt")
                .setAppSecret("rGgN4Yq3wrHgtgJLOQ6Xj6-1gNfg4AyLh2cwFavqGobl2viCwnrspm2zxSL8sWec");
        try {
            System.out.println(client.getAccessToken(getAccessTokenRequest).body.getAccessToken());
            return client.getAccessToken(getAccessTokenRequest).body.getAccessToken();
        } catch (TeaException err) {
            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
                // err 中含有 code 和 message 属性，可帮助开发定位问题
            }

        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
                // err 中含有 code 和 message 属性，可帮助开发定位问题
            }

        }
        return client.getAccessToken(getAccessTokenRequest).body.getAccessToken();
    }
}
