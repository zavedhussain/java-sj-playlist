package generic;

public class PrintString {

    String value;

    PrintString(String value){
        this.value = value;
    }

    public void setValue(String val){
        this.value = val;
    }

    public String getValue(){
        return value;
    }
}
