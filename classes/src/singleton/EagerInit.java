package singleton;

public class EagerInit {
    //private static methods and variables
    private static EagerInit instance = new EagerInit();

    //constructor is private
    private EagerInit(){

    }

    //only get instance is public
    public static EagerInit getInstance(){
        return instance;
    }
}
