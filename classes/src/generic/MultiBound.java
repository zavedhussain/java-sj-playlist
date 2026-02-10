package generic;

//public class MultiBound<T extends Runnable>{
public class MultiBound<T extends Number & Runnable & Cloneable>{

    //note that once generics is defined in this way
    //T has to be a subclass of number that implements both Runnable and clonable
    //always use extends not implements
    //X implements Interface1 not allowed
}
