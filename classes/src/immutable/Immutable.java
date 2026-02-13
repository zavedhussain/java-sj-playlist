package immutable;

import java.util.ArrayList;
import java.util.List;

//class is final to prevent extension of class and then changing its attributes or methods
public final class Immutable {

    //attributes are private and final to avoid future modifications outside of constructor
    private final String val;
    private final List <String> list;

    //constructor is the only object receives values for its attributes
    public Immutable(String val, List<String> list){
        this.val = val;
        this.list = list;
    }

    //String is already immutable return as is
    public String getVal(){
        return this.val;
    }

    //return a deep copy of list so that original remains unmodifiable
    public List<String> getList(){
        return new ArrayList<>(list);
    }

    //keep only getters ,no setter to prevent modification
}
