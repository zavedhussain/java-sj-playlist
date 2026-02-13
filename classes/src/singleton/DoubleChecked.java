package singleton;

public class DoubleChecked {
    //volatile keyword used to ensure read and write happens in memory
    //and not in cpu cache
    private static volatile DoubleChecked instance;

    private DoubleChecked(){};

    //double null check to prevent blocking of threads due to locking
    //if instance created immediately returned for all no locking
    //if no instance, go inside synch block to initialize,
    //check again in case  lock released and some one else created already
    public static DoubleChecked getInstance(){
        if(instance == null){
            synchronized (DoubleChecked.class){
                if(instance == null){
                    instance = new DoubleChecked();
                }
            }
        }
        return instance;
    }
}
