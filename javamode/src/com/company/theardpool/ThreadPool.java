package com.company.theardpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        //1.创建线程
        MyThread myThread=new MyThread();
        //1.创建线程池
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        //2.向线池中布置任务
        executorService.execute(myThread);
        //3.关闭线程池
        executorService.shutdown();
    }
}
