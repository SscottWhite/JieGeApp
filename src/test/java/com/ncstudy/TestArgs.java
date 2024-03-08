package com.ncstudy;

import com.ncstudy.toolutils.DES3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.IllegalBlockSizeException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestArgs {

    @Test
    public void tset1() throws IllegalBlockSizeException {

        System.out.println(Integer.MAX_VALUE*1.7);

        System.out.println(DES3.decryptThreeDESECB("123", DES3.DES3KEY));
    }
}
