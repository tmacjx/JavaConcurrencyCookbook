package ch1.sub8;

/**
 * 在线程里处理不受控制的异常
 *
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
