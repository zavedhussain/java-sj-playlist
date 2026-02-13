package singleton;

public class LazyInit {
    private static LazyInit instance;

    private LazyInit(){

    }
    //initialize later to prevent memory overhead if object not used
    //but can cause concurrency issues
    public static LazyInit getInstance(){
        if(instance == null){
            instance = new LazyInit();
        }
        return instance;
    }
}
