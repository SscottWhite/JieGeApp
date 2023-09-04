package com.ncstudy.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.*;
import java.util.concurrent.*;

public class TestMain {

    private final static int NUM_OF_THREADS=8;
    private final static long DATA_SIZE = 100000;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Map newMap = new HashMap<String,String>();
//        newMap.put("jack","123");
//
//        Iterator<Map.Entry<String,String>> iterator = newMap.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String,String> entry = iterator.next();
//            System.out.println(entry.getKey()+entry.getValue());
//        }
//
//        newMap.forEach((key,value) -> {
//            System.out.println(key+":"+value);
//        });

//         test1();//
//         test3();
//         test4();

        HashSet<String> set1 = test0(DATA_SIZE);
        HashSet<String> set2 = test0(DATA_SIZE);
        ExecutorService es = Executors.newFixedThreadPool(NUM_OF_THREADS);
        CompletionService<Boolean> cs = new ExecutorCompletionService<>(es);

        long startTime = System.currentTimeMillis();

        for(int i=0;i<DATA_SIZE;i += (DATA_SIZE/NUM_OF_THREADS)){
            final int start = i;
            cs.submit(()->{
                for(int j = start;j<start+(DATA_SIZE/NUM_OF_THREADS);j++){
                    if(!set2.contains(set1.toArray()[j])){
                        return false;
                    }
                }
                return true;
            });
        }

        int finishTask = 0;
        Boolean isTrue = true;
        while (finishTask < NUM_OF_THREADS){
            Future<Boolean> future = cs.take();
            if(!future.get()){
                isTrue = false;
                break;
            }
            finishTask++;
        }

        es.shutdown();

        System.out.println("有差异吗?"+isTrue);
        System.out.println("耗时:"+(System.currentTimeMillis()-startTime));
    }

    public static HashSet<String> test0(long size){
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0;i<size;i++){
            hashSet.add("item "+i);
        }
        return hashSet;
    }

    public static void  test1(){
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 600; i++) {
            list.add(i);
        }
       // ExecutorService es = Executors.newFixedThreadPool(100, new ThreadFactoryBuilder().setNameFormat("touch-send-worker-%d").build());
        ExecutorService es = new ThreadPoolExecutor(4,5,0,
                    TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(),new ThreadPoolExecutor.DiscardPolicy());
        int size = list.size();
        int batch = size % 100 == 0 ? size / 100 : size / 100 + 1;
        for (int i = 0; i < batch; i++) {
            int end = (i+1)*100;
            if(end > size) end = size;
            List<Integer>  newList = list.subList(i*100,end);
            es.execute(() -> test2(newList));
          //  es.shutdown();
            if(es.isTerminated()) break;
        }
        es.shutdown();
    }

    public static void test2(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("**"+i+"**"+Thread.currentThread().getName());
        }
    }

    public static void test3() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<String> future = es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "jack !";
            }
        });
        es.shutdown();
        System.out.println(future.get());
    }

    public static void test4() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "rose !";
            }
        });
        es.submit(futureTask);
        es.shutdown();
        System.out.println(futureTask.get());
    }
}
