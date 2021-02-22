package ch1.sub6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("Begin data source loading: %s\n", new Date());
        try{
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Data source loading has finished: %s\n", new Date());
    }
}
