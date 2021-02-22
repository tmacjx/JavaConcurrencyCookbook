package ch3.sub4;

/**
 *
 * 等待多个并发事件的完成
 * CountDownLatch，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。它提供了await()、countDown()两个方法来进行操作。
 */
public class Main {
    public static void main(String[] args) {

        VideoConference conference = new VideoConference(3);
        Thread threadConference = new Thread(conference);
        threadConference.start();

        for(int i = 0; i < 10; i++){
            Participant participant = new Participant(conference, "Participant" + i);
            Thread thread = new Thread(participant);
            thread.start();
        }


    }

}
