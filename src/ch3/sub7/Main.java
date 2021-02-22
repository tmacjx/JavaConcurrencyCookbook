package ch3.sub7;

/**
 * 并发阶段任务中的阶段切换
 *   Phaser  OnAdvance
 */
public class Main {
    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser();
        Student[] students = new Student[5];
        for(int i = 0; i < 5; i++){
            students[i] = new Student(myPhaser);
            myPhaser.register();
        }

        Thread[] threads = new Thread[5];
        for(int i = 0; i < 5; i++){
            threads[i] = new Thread(students[i], "Student " + i);
            threads[i].start();
        }

        for(int i = 0; i < 5; i++){
            try{
                threads[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.printf("Main: The phaser has finished: %s\n", myPhaser.isTerminated());

    }
}
