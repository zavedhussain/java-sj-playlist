package completableFutures;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        //advanced version of Future
        //provides chaining of tasks



        CompletableFuture<String> futureObj = CompletableFuture.supplyAsync(()->{
            return "Task completed in! "+Thread.currentThread().getName();
        },executor);

        CompletableFuture<String> futureObj3 = CompletableFuture.supplyAsync(()->{
            return "Task completed in! "+Thread.currentThread().getName();
        },executor);

//        futureObj = futureObj.thenRun(()->{
//            System.out.println("Runnable Task completed!");
//        });


        /*
        Use thenApply() when the operation you want to perform after the current future
        completes is a synchronous value-returning function that doesn't involve another
        asynchronous call or waiting for another future. The method automatically wraps the
        result of your function into a new CompletableFuture for the next stage in the chain.
        */

//        futureObj = futureObj.thenApply((val)->{
//            return val+ "\nCompleted second task in thread!"+ Thread.currentThread().getName();
//        });

        futureObj = futureObj.thenApplyAsync((String val)->{
            return val+ "\nCompleted second task in thread!"+ Thread.currentThread().getName();
        },executor);

        /*
        Use thenCompose() when the operation following the current future is another asynchronous action
        that itself returns a CompletableFuture.
        This method prevents nested futures (e.g., CompletableFuture<CompletableFuture<U>>) by "flattening" the
        result into a single CompletableFuture<U>, allowing for a clean, continuous chain of operations.
        */


        futureObj = futureObj.thenComposeAsync((String val)->{

            return CompletableFuture.supplyAsync(()->{
                return val + "\nChained Async Task completed in thread! "+Thread.currentThread().getName();
            },executor);
        });


//        CompletableFuture<Void> futureObj2 = futureObj.thenAcceptAsync((String val)->{
//            System.out.println("Consumed a task in thread: "+ Thread.currentThread().getName());
//        },executor);

        CompletableFuture<String> combinedFutureObj = futureObj.thenCombineAsync(futureObj3,
                (val1, val2)-> val1+"\n"+val2,executor);

        try{
//            System.out.println(futureObj.get());
            System.out.println(combinedFutureObj.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        executor2.shutdown();
    }
}
