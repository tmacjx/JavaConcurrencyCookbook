package ch3.sub5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {
    private MatrixMock mock;
    private int firstRow;
    private int lastRow;
    private Results results;
    private int number;
    private CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier ){
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int counter;
        System.out.printf("%s: Processing lines from %d to %d.\n",Thread.currentThread().getName(),firstRow,lastRow);
        for(int i = firstRow; i < lastRow; i++){
               int[] row =  mock.getRow(i);
               counter = 0;
               for(int j = 0; j < row.length; j++){
                   if(row[j] == number){
                       counter++;
                   }

               }
               results.setData(i, counter);
        }
        System.out.printf("%s: Lines processed.\n",Thread. currentThread().getName());
        try{
            // 等待其他线程完成
            barrier.await();
        }catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
        System.out.println("Finished All");

    }
}
