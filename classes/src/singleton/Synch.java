package singleton;

public class Synch {
    private static Synch instance;

    private Synch(){

    }

    // add synchronized to avoid concurrency issues
    // but locking/unlocking leads to blocking of threads
    public synchronized static Synch getInstance(){
        if(instance == null){
            instance = new Synch();
        }
        return instance;
    }
}
