package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args){
        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResource resource1 = new SharedResource(lock);
        SharedResource resource2 = new SharedResource(lock);

        Thread th1 = new Thread(()->{
            resource1.read();
        });

        Thread th2 = new Thread(()->{
            resource2.read();
        });

        th1.start();
        th2.start();
    }

}
