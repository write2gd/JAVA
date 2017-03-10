package com.gd.java.test.gt.pc.gt2;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by dasg on 03-03-2017.
 */
public class Producer implements Runnable {
    private Queue<Number> producerQue;

    public Producer(Queue<Number> sharedQueue) {
        this.producerQue = sharedQueue;
    }

    @Override
    public void run() {
        double number ;
        while (true){
            try{
                number = Math.random()*100+29;
                synchronized (MainClass.sim){
                    producerQue.add(number);
                    System.out.println("<<<<<<<<< Produced: "+number);
                    MainClass.sim.wait();
                }

               // Thread.sleep(100);
            }
            catch(Exception e){
                System.out.println("**********Error in Producer**********");
                System.out.println(e.getMessage());
            }
            finally {

            }
        }
    }
}
