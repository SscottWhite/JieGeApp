package com.ncstudy.vo;

import java.io.*;

public class USe123 implements Externalizable {

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
