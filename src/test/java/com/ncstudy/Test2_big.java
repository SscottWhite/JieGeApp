package com.ncstudy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.ncstudy.Persons;

public class Test2_big {

	/**
	 * 循环sunSum 好像是4, 所以这个maxinumsize最大值要 >= 4, 不然会执行拒绝策略
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService es = new  ThreadPoolExecutor(
					2,4,
					60,TimeUnit.SECONDS,
					new SynchronousQueue<Runnable>(),
					Executors.defaultThreadFactory(),
					new ThreadPoolExecutor.AbortPolicy());
		
		List<Future<String>> fList = new ArrayList<Future<String>>();
		List<Persons> list = BigPojos.getBigList();
		MyBigCall mbc;
		int size = list.size();
		int sunSum = 2 * Runtime.getRuntime().availableProcessors();//看个人电脑, 这边是2*2	
		int listStart, listEnd;
		
		if(sunSum > size) {
			sunSum = size;
		}
		
		for(int i = 0; i < sunSum; i++) {
			listStart = size / sunSum * i;
			listEnd = size / sunSum * ( i+1 );
			
			if(i == sunSum - 1) listEnd = size;
			
			List<Persons> sunList = list.subList(listStart,listEnd);
			mbc = new MyBigCall(i,sunList);
			//一次5万条, 总共4次
			Future<String> futures = es.submit(mbc);
			//fList.add(es.submit(mbc));  //这边就正式的把内容加进来
			if(futures.isDone()){
				fList.add(futures);
				continue;
			}
		}
//如果要求顺序, 那就不分级了, 直接全放进去		
//		mbc = new MyBigCall(1,list);
//		fList.add(es.submit(mbc));
		for (Future future: fList) {
			try {
				String str ;
				if(null != future ){
					str = future.get().toString();
					System.out.println("##############current thread id ="+Thread.currentThread().getName()+",result="+str);
				}else{
					System.err.println("失败");
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();	
			}
		}
		
		es.shutdown();
	}
}
