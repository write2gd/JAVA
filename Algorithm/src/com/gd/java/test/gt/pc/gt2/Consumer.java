package gt.pc.gt2;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by dasg on 03-03-2017.
 */
public class Consumer implements Runnable{
    private Queue<Number> consumerQue;

    public Consumer(Queue<Number> consumerQue) {
        this.consumerQue = consumerQue;
    }

    @Override
    public void run() {
        while (true){
            try{
            Thread.sleep(1000);
            if(consumerQue.isEmpty()){
                System.out.println("***QUE is Empty");
            }else {

                synchronized (MainClass.sim) {
                    Number number = consumerQue.poll();
                    System.out.println(">>>>>>Consumed: " + number);
                    MainClass.sim.notify();

                }
            }
                   // Thread.sleep(150);
                }catch (Exception e){
                    System.out.println("**********Error in Consumer**********");
                    System.out.println(e.getMessage());
                }
                finally {

                }



        }
    }
}
