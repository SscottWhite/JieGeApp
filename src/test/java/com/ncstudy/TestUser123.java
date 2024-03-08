package com.ncstudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser123 {

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

class USe123 implements Externalizable {

    // private static final long serialVersionUID = -8968758694052825911L; // Externalizable {

    //private static final long serivalVersionUID = 1L;

    private String name;
    private transient int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public USe123() {
    }

    @Override
    public String toString() {
        return "USer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public USe123(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(age);
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.age = in.readInt();
        this.name = (String) in.readObject();
    }
}
