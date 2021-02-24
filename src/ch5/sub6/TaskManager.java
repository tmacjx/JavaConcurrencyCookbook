package ch5.sub6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

public class TaskManager {
    private List<ForkJoinTask<Integer>> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }

    public void addTask(ForkJoinTask<Integer> task){
        tasks.add(task);
    }

    public void cancelTasks(ForkJoinTask<Integer> cancelTask){
        for (ForkJoinTask<Integer> task :tasks) {
            if (task != cancelTask) {
                // 尝试取消任务，如果任务进行中，则无法取消
                task.cancel(true);
                ((Task)task).writeCancelMessage();
            }
        }
    }



}
