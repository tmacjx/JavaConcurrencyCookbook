package ch2.sub7;

import ch2.sub5.Job;
import ch2.sub5.PrintQueue;

/**
 * 修改锁的公平性
 * 释放锁后，再次获得，将选择等待时间最长的线程
 */
public class Main {
    public static void main(String[] args) {
        ch2.sub5.PrintQueue queue = new PrintQueue();
        Job job = new Job(queue);
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++){
            threads[i] = new Thread(job);
        }

        for(int i = 0; i < 10; i++){
            threads[i].start();
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }
}
