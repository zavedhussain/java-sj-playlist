package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        Runnable runnableObj = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task completed by "+ Thread.currentThread().getName());
            }
        };

        Callable<Integer> callableObj = new Callable<>() {
            @Override
            public Integer call() {
                System.out.println("Task completed by "+ Thread.currentThread().getName());
                return 45;
            }
        };

        List<Integer> output = new ArrayList<>();
        Runnable runnableObj2 =  new Runnable(){

            @Override
            public void run() {
                System.out.println("Task completed by "+ Thread.currentThread().getName());
                output.add(99);
            }
        };


        // 3 flavours of submit in executor
        Future<?> futureObj1 =  executor.submit(runnableObj);
        Future<Integer> futureObj2 =  executor.submit(callableObj);
        Future<List<Integer>> futureObj3 =executor.submit(runnableObj2,output);

//        executor2.shutdown();

        try{
            futureObj1.get();
            System.out.println(futureObj2.get());
            System.out.println(futureObj3.get().get(0));
        }catch (Exception e){
            //
        }
    }
}
