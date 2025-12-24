package ProducerConsumer;

public class Main {
    public static void main(String[] args){
        SharedBuffer buffer = new SharedBuffer(5);

        Thread th1 = new Thread(new Producer(buffer));
        Thread th2 = new Thread(new Consumer(buffer));
        th1.start();
        th2.start();
    }
}
