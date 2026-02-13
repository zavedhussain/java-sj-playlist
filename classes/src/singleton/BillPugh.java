package singleton;

public class BillPugh {
    // bill pugh solution avoids concurrency issues as well as eager initialization
    //by using a nested static class which is not loaded on program start but only when it is referred
    private BillPugh(){};

    private static class SingletonHelper{
        private static final BillPugh instance = new BillPugh();
    }

    public static BillPugh getInstance(){
        return SingletonHelper.instance;
    }
}
