package executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){

//        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
//                new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
//
//        executor.allowCoreThreadTimeOut(true);

        CustomThreadFactory threadFactory = new CustomThreadFactory();
        CustomRejectionHandler rejectionHandler = new CustomRejectionHandler();

        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), threadFactory, rejectionHandler);

        for(int i=0; i<7; i++){
            executor2.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try{
                    Thread.sleep(3000);
                } catch (Exception e){
                    //
                }
            });
        }
        executor2.shutdown();
    }
}
