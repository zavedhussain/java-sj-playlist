public class SharedResourceSync {
    private int normalInt;

    SharedResourceSync(int val){
        this.normalInt = val;
    }

    public synchronized void increment(){
        normalInt++;
    }

    public int get(){
        return normalInt;
    }
}
