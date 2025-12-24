package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private int CAPACITY;
    private Queue<Integer> queue;

    SharedBuffer(int capacity){
        this.CAPACITY = capacity;
        queue = new LinkedList<>();
    }

    public synchronized void produce(int value){
        try{
            while(queue.size() == CAPACITY){
                System.out.println("Producer waiting as buffer full!");
                wait();
            }
            queue.offer(value);
            System.out.println("Pushed value :"+value+" into buffer");
            notifyAll();
        }catch (Exception e){
            //exception handling
        }

    }

    public synchronized void consume(){
        try{
            while(queue.isEmpty()){
                System.out.println("Consumer waiting as buffer empty!");
                wait();
            }
            System.out.println("Consumed value: "+ queue.poll()+" from buffer");
            notifyAll();
        }catch (Exception e){
            //exception handling
        }

    }
}
