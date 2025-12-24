package Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    boolean isAvailable;
    ReentrantLock lock;
    Condition condition;

    SharedResource(ReentrantLock lock){
        this.isAvailable= false;
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    public void produce(){
        System.out.println("Entering produce method");
        lock.lock();

        while (isAvailable){
            try {
                condition.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Lock acquired by :"+Thread.currentThread().getName());
        this.isAvailable = true;
        System.out.println("Updated isAvailable inside produce :"+isAvailable);
        condition.signal();
        try {
            Thread.sleep(3000);

        }catch (Exception e){
            //
        }

        lock.unlock();
        System.out.println("Lock released by :"+Thread.currentThread().getName());
    }

    public void consume(){
        System.out.println("Entering consume method");
        lock.lock();

        while (!isAvailable){
            try {
                condition.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Lock acquired by :"+Thread.currentThread().getName());
        this.isAvailable = false;
        System.out.println("Consumed isAvailable inside consume :"+isAvailable);
        condition.signal();
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            //
        }
        lock.unlock();
        System.out.println("Lock released by :"+Thread.currentThread().getName());
    }
}
