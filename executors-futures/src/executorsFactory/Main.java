package executorsFactory;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args){

        // create a thread pool executor with fixed no of threads
        // unbounded queue with unlimited thread idle time
        // good for fixed no of async tasks
        // bad for heavy workload
        ExecutorService fixedPoolExecutor = Executors.newFixedThreadPool(2);
        fixedPoolExecutor.submit(() -> System.out.println("Task completed by fixed pool executor"));

        // create a thread pool executor which dynamically creates and destroys threads
        // zero sized queue meaning no waiting, just create a new thread
        // 60 secs idle time as tasks expected to be short
        // good for bursts of short tasks
        // bad for long-running tasks as may cause memory overload
        ExecutorService cachedPoolExecutor = Executors.newCachedThreadPool();
        cachedPoolExecutor.submit(() -> System.out.println("Task completed by cached pool executor"));

        // create a new pool with single thread and unbounded queue
        // good for performing tasks sequentially without blocking main thread
        // no concurrency
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(() -> System.out.println("Task completed by single thread executor"));


//        ExecutorService forkJoinPool = Executors.newWorkStealingPool();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Future<Integer> futureObj = forkJoinPool.submit(new ComputeRecursiveTask(8));

        try {
            System.out.println("ForkJoin Task computed: "+futureObj.get());
        }catch (Exception e){
            //
        }
    }
}
