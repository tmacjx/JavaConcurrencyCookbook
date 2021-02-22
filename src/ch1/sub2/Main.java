package ch1.sub2;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取和设置线程信息
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Thread thread[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];
        for(int i = 0; i < 10 ; i++){
            thread[i] = new Thread(new Calculator(i));
            if ( (i % 2) == 0){
                thread[i].setPriority(Thread.MAX_PRIORITY);
            }else{
                thread[i].setPriority(Thread.MIN_PRIORITY);
            }
            thread[i].setName("Thread " + i);
        }
        try(FileWriter file = new FileWriter("./log.txt");
        PrintWriter pw = new PrintWriter(file);){
            for(int i = 0; i < 10; i++){
                status[i] = thread[i].getState();
                pw.println("Main: Status of Thread " + i + ":" + thread[i].getState());
            }

            for(int i = 0; i < 10; i++){
                thread[i].start();
            }

            boolean finish = false;
            while(!finish){
                for(int i = 0; i < 10; i++){
                    if (thread[i].getState() != status[i]){
                        writeThreadInfo(pw, thread[i], status[i]);
                        status[i] = thread[i].getState();
                    }
                }
                finish = true;
                for(int i = 0; i < 10; i++){
                    finish = finish && (thread[i].getState() == status[i]);
                }
            }
        }
    }
    public static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state){
        pw.printf("Main: Id %d - %s \n",  thread.getId(), thread.getName());
        pw.printf("Main: Priority: %d\n", thread.getPriority());
        pw.printf("Main: Old State: %s\n", state);
        pw.printf("Main: New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }


}
