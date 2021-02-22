package ch1.sub11;

/**
 *  处理线程组内的不受控制异常
 */
public class Main {
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for(int i = 0; i < 2; i++){
            Thread t = new Thread(threadGroup, task);
            t.start();
        }

    }
}
