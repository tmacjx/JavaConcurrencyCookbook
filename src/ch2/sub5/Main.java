package ch2.sub5;

/**
 * 使用锁实现同步
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        Job job = new Job(queue);
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++){
            threads[i] = new Thread(job);
        }

        for(int i = 0; i < 10; i++){
            threads[i].start();
        }

    }
}
