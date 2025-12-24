package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    boolean isAvailable;
    ReentrantLock lock;

    SharedResource(ReentrantLock lock){
        this.isAvailable= false;
        this.lock = lock;
    }

    public void produce(){
        System.out.println("Entering produce method");
        lock.lock();
        System.out.println("Lock acquired by :"+Thread.currentThread().getName());
        this.isAvailable = true;
        System.out.println("Updated isAvailable inside produce :"+isAvailable);
        try {
            Thread.sleep(8000);

        }catch (Exception e){
            //
        }

        lock.unlock();
        System.out.println("Lock released by :"+Thread.currentThread().getName());
    }

    public void consume(){
        System.out.println("Entering consume method");
        lock.lock();
        System.out.println("Lock acquired by :"+Thread.currentThread().getName());
        this.isAvailable = false;
        System.out.println("Consumed isAvailable inside consume :"+isAvailable);
        try {
            Thread.sleep(8000);
        }catch (Exception e){
            //
        }
        lock.unlock();
        System.out.println("Lock released by :"+Thread.currentThread().getName());
    }
}
