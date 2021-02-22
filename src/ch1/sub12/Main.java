package ch1.sub12;

import ch1.sub11.MyThreadGroup;

/**
 * 用线程工厂创建线程
 */
public class Main {
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();
        Thread thread;
        for(int i = 0; i < 10; i++) {
            thread = factory.newThread(task);
            thread.start();
        }

        System.out.print("Factory stats:\n"); System.out.printf("%s\n", factory.getStats());

    }
}
