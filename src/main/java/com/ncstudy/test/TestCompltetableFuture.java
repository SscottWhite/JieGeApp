package com.ncstudy.test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCompltetableFuture {
    public static void main(String[] args) {
        // 创建一个CompletableFuture实例
        CompletableFuture<String> futurePrice = CompletableFuture.supplyAsync(() -> {
            // 模拟耗时操作，比如调用外部API
            simulateDelay();
            return "100元";
        });

        // runasync不带返回值
        CompletableFuture<Void> futureVoid = CompletableFuture.runAsync(() -> {
            simulateDelay();
        });

        // 在这里，咱们可以做一些其他的事情，不必等待价格查询的结果
        doSomethingElse();

        // 当结果准备好后，获取它
        String price = futurePrice.join();
        System.out.println("价格是：" + price);

      //  thenFuture();
     //   exceptionFuture();
        handleFuture();
    }

    private static void simulateDelay() {
        try {
            Thread.sleep(1000); // 模拟1秒的延迟
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void doSomethingElse() {
        // 做一些其他的事情
        System.out.println("小黑在做其他的事情...");
    }

     /* thenCombine */
     public static void combindFuture(){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
           simulateDelay();
           return "用户";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            simulateDelay();
            return "配置";
        });

        CompletableFuture<String> futureCombind = future1.thenCombine(future2,(user,config) -> {
            return "结果: "+user+", "+config;
        });
     }

     /* then */
     public static void thenFuture(){
         CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            return "thenFuture";
         });

         future.thenApply( result -> {
             return "处理1 : "+result;
         }).thenAccept( processedResult -> {
             System.out.println("最终结果: "+processedResult);
         }).thenRun(() -> {
             System.out.println("操作全部完成");
         });
     }

     /* exception */
     public static void exceptionFuture(){
         CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
             if(new Random().nextBoolean()){
                 throw new RuntimeException("出错");
             }
             return "正常结果";
         }).exceptionally(ex -> {
             return "错误的信息:"+ex.getMessage();
         });

         future.thenAccept(System.out::println);
     }

     /* handle */
     public static void handleFuture(){
         CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if(new Random().nextBoolean()){
                throw new RuntimeException("出错");
            }
            return "正常结果";
         }).handle((result,ex)->{
             if(ex != null){
                 return "处理异常:"+ex.getMessage();
             }
             return "处理结果: "+result;
         });
         future.thenAccept(System.out::println);
     }

     /* thenException */
     public static void thenExceptionFuture(){
         CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
             // 第一个异步操作
             return "第一步结果";
         }).thenApply(result -> {
             // 第二个异步操作，可能会出错
             throw new RuntimeException("第二步出错啦!");
         }).exceptionally(ex -> {
             // 处理异常
             return "在第二步捕获异常：" + ex.getMessage();
         }).thenApply(result -> {
             // 第三个异步操作
             return "第三步使用结果：" + result;
         });

         future.thenAccept(System.out::println);
     }

     public static void thenComoseFuture(){
         CompletableFuture<String> masterFuture = CompletableFuture.supplyAsync(() -> {
             simulateDelay();
             return "主数据结果";
         });

         CompletableFuture<String> dependentFuture = masterFuture.thenCompose(result -> {
             return CompletableFuture.supplyAsync(() -> {
                 simulateDelay();
                 return "处理后的数据";
             });
         });

         dependentFuture.thenAccept(System.out::println);
     }

     public static void allOfFuture(){
         CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
             simulateDelay();
             return "结果一";
         });

         CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
             simulateDelay();
             return "结果二";
         });

         CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);

         allFutures.thenRun(() -> {
             System.out.println("所有任务完成");
         });
     }

     public static void threadFuture(){
         ExecutorService customExecutor = Executors.newFixedThreadPool(10);
         CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
             return "使用自定义线程池";
         }, customExecutor);

         ExecutorService dbExecutor = Executors.newCachedThreadPool();
         CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
             // 这里是阻塞的数据库操作
             simulateDelay();
         }, dbExecutor);
     }

     public static void allExceptionFuture(){
         CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "任务1").exceptionally(ex -> "默认值1");
         CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "任务2").exceptionally(ex -> "默认值2");

         CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + " 和 " + result2);
     }

     public void thenApplyFuture(){
         CompletableFuture<String> future = CompletableFuture.supplyAsync(()->"原始数据")
                 .thenApply(this::step1)
                 .thenApply(this::step2)
                 .thenApply(this::step3);
     }

    // 将每个步骤的逻辑封装在不同的方法中
    private String step1(String data) {
        return "处理1：" + data;
    }

    private String step2(String data) {
        return "处理2：" + data;
    }

    private String step3(String data) {
        return "处理3：" + data;
    }
}
