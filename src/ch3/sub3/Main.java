package ch3.sub3;

import ch3.sub2.Job;
import ch3.sub2.PrintQueue;

/**
 * 资源的多副本的并发访问控制 -- 信号量
 *    Semaphore(number)
 */
public class Main {
    public static void main(String[] args) {
        ch3.sub2.PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}