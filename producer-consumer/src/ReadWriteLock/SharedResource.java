package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

class SharedResource {
    boolean isAvailable;
    ReadWriteLock lock;

    SharedResource(ReadWriteLock lock){
        this.isAvailable= false;
        this.lock = lock;
    }

    public void read(){
        System.out.println("Entering produce method");
        lock.readLock().lock();
        System.out.println("Lock acquired by :"+Thread.currentThread().getName());
        System.out.println("Read isAvailable inside read method :"+isAvailable);
        try {
            Thread.sleep(8000);

        }catch (Exception e){
            //
        }

        lock.readLock().unlock();
        System.out.println("Lock released by :"+Thread.currentThread().getName());
    }

    public void write(){
        System.out.println("Entering write method");
        lock.writeLock().lock();
        System.out.println("Lock acquired by :"+Thread.currentThread().getName());
        this.isAvailable = !isAvailable;
        System.out.println("Written isAvailable inside write method :"+isAvailable);
        try {
            Thread.sleep(8000);
        }catch (Exception e){
            //
        }
        lock.writeLock().unlock();
        System.out.println("Lock released by :"+Thread.currentThread().getName());
    }
}
