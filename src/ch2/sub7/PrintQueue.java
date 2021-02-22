package ch2.sub7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    // 非公平锁
    private final Lock queueLock = new ReentrantLock(true);

    public void printJob(Object document){
        queueLock.lock();
        try {
            long duration = (long) (Math.random() * 1000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during "
                    + (duration / 1000) + "seconds");
            Thread.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }
    }

}
