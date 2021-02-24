package ch4.sub2;

/**
 *  创建线程执行器
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        for (int i = 0; i < 100; i++){
            Task task = new Task("Task "+i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
