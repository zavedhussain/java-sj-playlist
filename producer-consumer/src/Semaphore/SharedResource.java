package Semaphore;
import java.util.concurrent.Semaphore;

class SharedResource {
    int a;
    boolean isAvailable;
    Semaphore lock;

    SharedResource(Semaphore lock){
        this.a= 10;
        this.isAvailable = false;
        this.lock = lock;
    }

    public void read(){

        System.out.println("Entering read method");
        try {
            lock.acquire();
            System.out.println("Lock acquired by :"+Thread.currentThread().getName());
            a++;
            Thread.sleep(8000);

        }catch (Exception e){
            //
        }finally {
            lock.release();
            System.out.println("Read isAvailable inside read method :"+isAvailable+"and a updated to: "+a);
            System.out.println("Lock released by :"+Thread.currentThread().getName());
        }


    }

//    public void write(){
//        System.out.println("Entering write method");
//
//        System.out.println("Lock acquired by :"+Thread.currentThread().getName());
//        try {
//            lock.a();
//            a++;
//            Thread.sleep(2000);
//        }catch (Exception e){
//            //
//        }
//        this.isAvailable = !isAvailable;
//        System.out.println("Written isAvailable inside write method :"+isAvailable +" and a updated to : "+a );
//        lock.unlockWrite(stamp);
//        System.out.println("Lock released by :"+Thread.currentThread().getName());
//    }
}
