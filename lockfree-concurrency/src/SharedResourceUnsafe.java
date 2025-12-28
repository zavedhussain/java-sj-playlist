public class SharedResourceUnsafe {
    private int normalInt;

    SharedResourceUnsafe(int val){
        this.normalInt = val;
    }

    public void increment(){
        normalInt++;
    }

    public int get(){
        return normalInt;
    }
}
