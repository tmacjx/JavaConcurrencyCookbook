package ch1.sub4;

import java.util.concurrent.TimeUnit;

/**
 * 操作线程的中断机制
 * 在外部调用interrupt时，thread的执行流程需要判断 是否处于中断状态
 * http://ifeve.com/thread-management-5/
 */
public class Main {
    public static void main(String[] args) {
        FileSearch fileSearch = new FileSearch("/", "abc.bat");
        Thread task = new Thread(fileSearch);
        task.start();

        try{
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        task.interrupt();
    }
}
