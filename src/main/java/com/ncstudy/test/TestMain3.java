package com.ncstudy.test;

public class TestMain3 {
        static int num = 0;

        public static  void m1() {
            synchronized (TestMain3.class) {
                for (int i = 0; i < 10000; i++) {
                    num++;
                    System.out.println(num);
                }
            }
        }

        public static class T1 extends Thread {
            @Override
            public void run() {
                TestMain3.m1();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            T1 t1 = new T1();
            T1 t2 = new T1();
            T1 t3 = new T1();
            t1.start();
            t2.start();
            t3.start();

            //等待3个线程结束打印num
            t1.join();
            t2.join();
            t3.join();

          //  System.out.println(TestMain3.num);
            /**
             * 打印结果：
             * 30000
             */
        }
    }
