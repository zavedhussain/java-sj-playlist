package generic;

import java.util.List;

public class WildCards {

    public <T> void printValue(List<T> someList){
        // print list
    }

    public <T extends Number> void printValue2(List<T> somelist){
        // print list
    }

    //not allowed as T represents a specific type which has to be related to Number so has to have a relevance
//    public <T super Number> void printValue2(List<T> someList){
//        // print list
//    }
    public void printValue3(List<? extends Number> someList){
        // print list
    }

    //this is only restriction , here the type has no relevance, we don't need the type
    public void printValue4(List<? super Number> someList){
        //print list
    }
}
