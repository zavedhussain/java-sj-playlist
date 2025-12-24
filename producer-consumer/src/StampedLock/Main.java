package StampedLock;

import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args){
        StampedLock lock = new StampedLock();
        SharedResource resource1 = new SharedResource(lock);
        SharedResource resource2 = new SharedResource(lock);

        Thread th1 = new Thread(()->{
            resource1.read();
        });

        Thread th2 = new Thread(()->{
            resource1.write();
        });

        Thread th3 = new Thread(()->{
            resource2.write();
        });

        th1.start();
        th2.start();
        th3.start();
    }

}
