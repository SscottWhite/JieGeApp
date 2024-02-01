package com.ncstudy;

import com.ncstudy.vo.USe123;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class USe123Test {

    @Test
    public void SerialUser() throws IOException {
        USe123 user = new USe123();
        user.setName("jack");
        user.setAge(10);
        ObjectOutputStream ooput = new ObjectOutputStream(new FileOutputStream("D://test//tset"));
        ooput.writeObject(user);
        ooput.close();
        System.out.println("已添加序列化:"+user.getAge());
    }

    @Test
    public void noSerialUSer() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("D://test//tset"));
        USe123 user = (USe123) input.readObject();
        System.out.println("结果是:"+user.getAge());
    }
}
