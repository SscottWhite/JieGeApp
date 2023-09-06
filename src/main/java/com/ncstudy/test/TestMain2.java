package com.ncstudy.test;


public class TestMain2 {
    private static Counter counter = new Counter();
    public static void main(String[] args) throws InterruptedException {

      //  test1();
        test2();
    }

    //一个死锁
    public static void test2(){
        ResouceLocktask resouceLocktask = new ResouceLocktask();
        new Thread(resouceLocktask, "线程A").start();
        new Thread(resouceLocktask, "线程B").start();
    }

    public static void test1() throws InterruptedException{
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });
        t1.start();
        t2.start();

        // 必须要在 t1 和 t2 都执行完后，再打印，否则 main 和 t1 t2 是并发关系
        // 导致t1 t2 还没执行完，就执行了下面的打印
        t1.join(); // 两个join 顺序前后没关系
        t2.join();

        // 在 main 中打印两个线程自增完 得到的 count
        System.out.println(counter.count);
    }



}


class Counter {
    public int count=0;
    public void increase(){
        this.count++;
    }
}

class ResouceLocktask implements Runnable {

    private Object o1 = new Object();
    private Object o2 = new Object();

    private boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            flag = false;
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "锁住资源o1，等到o2");
                try {
                    //这里的目的是
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "得到资源o2");

                }
            }
        } else {
            flag = true;
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "锁住资源o2，等到o1");

                try {
                    //这里的目的是防止一下获取到两个锁
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "得到资源o1");

                }
            }
        }
    }
}
