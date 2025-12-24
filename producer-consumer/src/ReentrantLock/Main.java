package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock();
        SharedResource resource1 = new SharedResource(lock);
        SharedResource resource2 = new SharedResource(lock);

        Thread th1 = new Thread(()->{
            resource1.produce();
        });

        Thread th2 = new Thread(()->{
            resource2.produce();
        });

        th1.start();
        th2.start();
    }

}
