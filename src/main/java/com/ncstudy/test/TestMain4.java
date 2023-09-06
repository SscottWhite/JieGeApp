package com.ncstudy.test;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class TestMain4 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        File file = new File("D:\\Users\\kjs_352\\Desktop\\1.txt");
        long len = file.length();
        byte[] bytes = new byte[(int) 10];

        try {
            MappedByteBuffer mbb = new RandomAccessFile(file,"r")
                    .getChannel()
                    .map(FileChannel.MapMode.READ_ONLY,0,len);
            for(int offset=0;offset<10;offset++){
                byte b = mbb.get();
                bytes[offset] = b;
            }

            Scanner scanner = new Scanner(new ByteArrayInputStream(bytes)).useDelimiter(" ");
            while (scanner.hasNext()){
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
