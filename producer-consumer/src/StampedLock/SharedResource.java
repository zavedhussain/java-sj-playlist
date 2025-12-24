package StampedLock;
import java.util.concurrent.locks.StampedLock;

class SharedResource {
    int a;
    boolean isAvailable;
    StampedLock lock;

    SharedResource(StampedLock lock){
        this.a= 10;
        this.isAvailable = false;
        this.lock = lock;
    }

    public void read(){
        try{
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Entering produce method");
        long stamp = lock.tryOptimisticRead();
        System.out.println("Optimistic read by :"+Thread.currentThread().getName());
        try {
            a++;
            Thread.sleep(8000);

        }catch (Exception e){
            //
        }
        if(lock.validate(stamp)){
            System.out.println("Read isAvailable inside read method :"+isAvailable+"and a updated to: "+a);
            System.out.println("Lock released by :"+Thread.currentThread().getName());
        }else{
            this.a = 10;
            System.out.println("Rollback of a :"+a);
        }

    }

    public void write(){
        System.out.println("Entering write method");
        long stamp = lock.writeLock();
        System.out.println("Lock acquired by :"+Thread.currentThread().getName());
        try {
            a++;
            Thread.sleep(2000);
        }catch (Exception e){
            //
        }
        this.isAvailable = !isAvailable;
        System.out.println("Written isAvailable inside write method :"+isAvailable +" and a updated to : "+a );
        lock.unlockWrite(stamp);
        System.out.println("Lock released by :"+Thread.currentThread().getName());
    }
}
