package singleton;

public class Main {
    public static void main(String[] args) {
        //best solution
        //easy and avoids all issues
        EnumSingleton instance = EnumSingleton.INSTANCE;

        EagerInit eagerInit = EagerInit.getInstance();

        LazyInit lazyInit = LazyInit.getInstance();

        Synch synch = Synch.getInstance();

        //most asked solution
        DoubleChecked doubleChecked = DoubleChecked.getInstance();

        //hacky but works
        BillPugh billPugh = BillPugh.getInstance();
    }
}
