package ch1.sub6;

/**
 * 等待线程的终结
 * join阻塞当前线程，直到被调用的线程完成
 */
public class Main {
    public static void main(String[] args) {
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread1 = new Thread((dsLoader));
        Thread thread2 = new Thread(ncLoader);

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
