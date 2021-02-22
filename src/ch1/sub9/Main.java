package ch1.sub9;

import java.util.concurrent.TimeUnit;

/**
 * 使用本地线程变量 ThreadLocal
 */
public class Main {
    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(task);
            thread.start();
        }
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
