package com.ncstudy.democollections;


import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


//https://juejin.cn/post/7252159509848899640
@RestController
@RequestMapping
public class TiKa {

    @Autowired
    private Tika tiKa;

    @GetMapping("/tika")
    @ResponseBody
    public void test() throws TikaException, IOException {
        Path path = Paths.get("D:\\工作内容\\工具\\00.pdf");
        File file = path.toFile();

        String parse = tiKa.parseToString(file);
        System.out.println(parse);
    }
}
