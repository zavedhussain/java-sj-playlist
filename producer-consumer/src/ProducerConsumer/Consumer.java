package ProducerConsumer;

public class Consumer implements Runnable{

    private SharedBuffer buffer;

    Consumer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true){
            buffer.consume();
            try{
                Thread.sleep(8000);
            }catch (Exception e){
                //exception
            }

        }
    }
}
