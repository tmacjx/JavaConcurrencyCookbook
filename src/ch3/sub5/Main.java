package ch3.sub5;

import java.util.concurrent.CyclicBarrier;

/**
 * 在集合点的同步
 *  CyclicBarrier，允许一组线程互相等待，直到到达某个公共屏障点。它提供的await()可以实现让所有参与者在临界点到来之前一直处于等待状态
 */
public class Main {

    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARTICIPANT = 2000;

        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);

        // 当此线程结束后，它会执行前面创建的 Grouper 对象。
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
        Searcher[] searchers = new Searcher[PARTICIPANTS];

        for(int i = 0; i < PARTICIPANTS; i++){
            searchers[i] = new Searcher(i * LINES_PARTICIPANT,
                    (i * LINES_PARTICIPANT) + LINES_PARTICIPANT, mock, results, 5,barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.print("Main: The main thread has finished.\n");

    }
}
