package generic;

public class PrintGeneric<T> {

    T value;

    PrintGeneric(){}

    PrintGeneric(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T val){
        this.value = val;
    }
}
