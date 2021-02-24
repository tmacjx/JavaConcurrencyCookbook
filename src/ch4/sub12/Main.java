package ch4.sub12;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 处理在执行器中被拒绝的任务
 */
public class Main {
    public static void main(String[] args) {
        RejectedExecutionHandler controller = new RejectTaskController();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(controller);
        System.out.print("Main: Starting.\n");
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task" + i);
            executor.submit(task);
        }

        System.out.print("Main: Shutting down the Executor.\n");

        executor.shutdown();

        // 执行器关闭后，尝试提交，会触发拒绝策略
        System.out.print("Main: Sending another Task.\n");
        Task task = new Task("RejectedTask");
        executor.submit(task);

        System.out.println("Main: End");
        System.out.print("Main: End.\n");


    }
}
