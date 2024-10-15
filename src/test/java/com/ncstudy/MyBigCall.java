package com.ncstudy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.ncstudy.Persons;

public class MyBigCall implements Callable {

	Lock lock = new ReentrantLock();
	private int pages;
	
	private List<Persons> list;
	
	public MyBigCall(int page, List<Persons> list1) {
		this.pages = page;
		this.list = list1;
	}
	
	@Override
	public Object call() throws Exception {
		System.err.println(String.format("此批数据的段数为:%s 此段数据的数据条数为:%s",pages,list.size()));		
		
		lock.lock();
		Boolean result = Boolean.TRUE;
		if(null != list && list.size() >0){
			for(Persons person: list){		
				FileOutputStream fos = null;
				ByteArrayOutputStream baos = null;
				try {			
					baos = new ByteArrayOutputStream();
					String msg = person.getName();
					
					byte[] hh = "\r\n".getBytes(); //换行
					byte[] datas = msg.getBytes();// 字符串-->字节数组(编码)
					fos = new FileOutputStream(new File("D:\\123.txt"),true);	//写入文件 --true: 追加内容不覆盖					
					// 获取数据		
					baos.write(datas, 0, datas.length);
					baos.write(hh, 0, hh.length);
					baos.writeTo(fos);  //覆盖
					
					fos.flush();
					baos.flush();

				} catch (Exception e) {					
					result = Boolean.FALSE;
					continue;
				} finally {
					try {
						if (null != baos) 
							baos.close();	
						if (null != fos) 
							fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		lock.unlock();
		return result;
	}
}
