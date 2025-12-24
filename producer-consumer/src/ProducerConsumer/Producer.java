package ProducerConsumer;

public class Producer implements Runnable{
    private SharedBuffer buffer;
    private int value;

    Producer(SharedBuffer buffer){
        this.buffer = buffer;
    }


    @Override
    public void run() {
        while(true){
            value++;
            buffer.produce(value);
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                //exception
            }

        }
    }
}
