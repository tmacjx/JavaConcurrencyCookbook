package ch3.sub4;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable{
    private final CountDownLatch controller;

    public VideoConference(int number) {
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());

        try{
            controller.await();
            System.out.print("VideoConference: All the participants have come\n");
            System.out.print("VideoConference: Let's start...\n");

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
