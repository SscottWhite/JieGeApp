package com.ncstudy.control;

import com.ncstudy.service.TestThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("thread")
public class ThreadController {

    private TestThreadService testThreadService;
    @Autowired
    public ThreadController(TestThreadService testThreadService){
        this.testThreadService = testThreadService;
    }

    @GetMapping("testThread")
    public void testThread(){
        testThreadService.testAsync();
    }
}
