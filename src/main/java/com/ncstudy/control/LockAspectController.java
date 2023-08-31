package com.ncstudy.control;

import com.ncstudy.service.LockAspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lock")
public class LockAspectController {

    @Autowired
    private LockAspectService lockAspectService;
    @PostMapping("test1")
    public void test(){
        lockAspectService.test1();
    }
}
