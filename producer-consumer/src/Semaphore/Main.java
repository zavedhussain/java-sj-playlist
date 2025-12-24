package Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args){
        Semaphore lock = new Semaphore(2);
        SharedResource resource1 = new SharedResource(lock);
//        SharedResource resource2 = new SharedResource(lock);

        Thread th1 = new Thread(()->{
            resource1.read();
        });

        Thread th2 = new Thread(()->{
            resource1.read();
        });

        Thread th3 = new Thread(()->{
            resource1.read();
        });

        Thread th4 = new Thread(()->{
            resource1.read();
        });

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }

}
