package ch4.sub2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        // 缓存线程池
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        // 固定线程池
        // executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        // 单例线程池
        executor = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
    }
    public void executeTask(Task task) {
        System.out.print("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }



}
