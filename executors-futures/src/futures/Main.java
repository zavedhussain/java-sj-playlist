package futures;

import executors.CustomRejectionHandler;
import executors.CustomThreadFactory;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args){

        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        Future<?> futureObj =  executor2.submit(() -> {
            try{
                Thread.sleep(8000);
            } catch (Exception e){
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println("Task completed by "+ Thread.currentThread().getName());
        });
        try{
            futureObj.get(2, TimeUnit.SECONDS);
        }catch (Exception e){
            //
            System.out.println("TimeoutException happened");
        }

        System.out.println("Future state is: "+futureObj.state());
        boolean isCancelled = futureObj.cancel(true);
        System.out.println("Future cancel command returns: "+isCancelled);
        System.out.println("Future done status: "+futureObj.isDone());
        System.out.println("Future cancelled status: "+futureObj.isCancelled());

//        executor2.shutdown();
    }
}
