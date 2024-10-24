package com.ncstudy.task;

import com.ncstudy.vo.Person;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class FileInsertCallable implements Callable {


    Lock lock = new ReentrantLock();

    private int page;
    private List<Person> list;

    public FileInsertCallable(int page, List<Person> list){
        this.page = page;
        this.list = list;
    }
    @Override
    public Object call()  {
        log.error(String.format("此批数据的段数为:%s 此段数据的数据条数为:%s",page,list.size()));
        lock.lock();
        Boolean result = Boolean.TRUE;
        if(null != list && list.size() >0){
            for (Person person : list) {
                FileOutputStream fos = null;
                ByteArrayOutputStream baos = null;
                try {
                    baos = new ByteArrayOutputStream();
                    String msg = person.getName();
                    byte[] hh = "\r\n".getBytes();
                    byte[] datas = msg.getBytes();

                    fos = new FileOutputStream(new File("D:\\123.txt"),true);
                    baos.write(datas,0,datas.length);
                    baos.write(hh,0,hh.length);
                    baos.writeTo(fos);

                    fos.flush();
                    baos.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    result = Boolean.FALSE;
                    continue;
                } catch (IOException e) {
                    e.printStackTrace();
                    result = Boolean.FALSE;
                    continue;
                } finally {

                   try {
                       if(null != baos)
                           baos.close();
                       if(null != fos)
                           fos.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                    }

                }


            }
        }
        lock.unlock();
        return result;
    }
}
