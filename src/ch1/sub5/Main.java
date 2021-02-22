package ch1.sub5;

import java.util.concurrent.TimeUnit;

/**
 * 线程的睡眠和恢复
 * sleep 让线程对象离开CPU
 *
 */
public class Main {

    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        thread.interrupt();

    }
}
