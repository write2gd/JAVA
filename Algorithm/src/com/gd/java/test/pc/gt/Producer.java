package com.gd.java.test.pc.gt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dasg on 03-03-2017.
 */
public class Producer implements Runnable {
    private BlockingQueue<Number> producerQue;

    public Producer(BlockingQueue<Number> sharedQueue) {
        this.producerQue = sharedQueue;
    }

    @Override
    public void run() {
        double number ;
        while (true){
            try{
                number = Math.random()*100+29;
                producerQue.put(number);
                System.out.println("<<<<<<<<< Produced: "+number);
                Thread.sleep(100);
            }
            catch(Exception e){
                System.out.println("**********Error in Producer**********");
            }
            finally {

            }
        }
    }
}
