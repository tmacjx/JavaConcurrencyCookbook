package ch3.sub2;


/**
 * 资源的并发访问控制
 *    Semaphore
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];

        for(int i = 0; i < 10; i++){
            threads[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        for(int i = 0; i < 10; i++){
            threads[i].start();
        }
    }
}
