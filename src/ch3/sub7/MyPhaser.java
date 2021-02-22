package ch3.sub7;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

    /**
     * onAdvance表明Phaser终止与否
     * phase表示阶段
     * Phaser对象进行阶段切换的时候，
     * 在所有在arriveAndAwaitAdvance()方法里休眠线程被唤醒之前，onAdvance()方法将被自动调用
     */
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase){
            case 0:
                return studentArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishSecondExercise();
            case 3:
                return finishExam();
            default:
                return true;
        }
    }

    private boolean studentArrived(){
        System.out.print("Phaser: The exam are going to start.The student are ready!\n");
        System.out.printf("Phaser: We have %d students\n", getRegisteredParties());
        return false;
    }

    private boolean finishFirstExercise(){
        System.out.print("Phaser: All the students have finished first exercise\n");
        System.out.print("Phaser: It's time for the second one");
        return false;
    }

    private boolean finishSecondExercise(){
        System.out.print("Phaser: All the students have finished second exercise\n");
        System.out.print("Phaser: It's time for the third one");
        return false;
    }

    private boolean finishExam(){
        System.out.print("Phaser: All the students have finished the exam\n");
        System.out.print("Phaser: Thank you for you time\n");
        return false;
    }


}
