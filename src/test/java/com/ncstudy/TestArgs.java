package com.ncstudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestArgs {

    @Test
    public void tset1(){

        System.out.println(Integer.MAX_VALUE*1.7);
    }
}
