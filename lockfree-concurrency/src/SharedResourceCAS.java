import java.util.concurrent.atomic.AtomicInteger;

public class SharedResourceCAS {
    private AtomicInteger atomicInt;

    SharedResourceCAS(int val){
        this.atomicInt = new AtomicInteger(val);
    }


    public void increment(){
        this.atomicInt.incrementAndGet();
    }

    public int get(){
        return this.atomicInt.get();
    }
}
