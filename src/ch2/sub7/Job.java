package ch2.sub7;


public class Job implements Runnable{
    private final PrintQueue printQueue;

    public Job(PrintQueue queue) {
        this.printQueue = queue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }
}
