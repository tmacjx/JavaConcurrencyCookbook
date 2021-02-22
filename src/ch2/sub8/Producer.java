package ch2.sub8;


public class Producer implements Runnable{
    private Buffer buffer;
    private FileMock mock;

    public Producer(FileMock fileMock, Buffer buffer){
        this.mock = fileMock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()){
            String line = mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
