package ch2.sub8;

/**
 * 在锁中使用多条件(Multiple Condition)
 */
public class Main {
    public static void main(String[] args) {
        FileMock mock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);

        Producer producer = new Producer(mock,buffer);
        Thread threadProducer = new Thread(producer, "Producer");

        Consumer[] consumers = new Consumer[3];
        Thread[] threadConsumer = new Thread[3];
        for(int i = 0; i < 3; i++){
            consumers[i] = new Consumer(buffer);
            threadConsumer[i] = new Thread(consumers[i]);
        }

        threadProducer.start();

        for(int i = 0; i < 3; i++){
            threadConsumer[i].start();
        }
    }
}
