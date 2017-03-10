package com.gd.java.test.pc.gt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by dasg on 03-03-2017.
 */
public class Consumer implements Runnable{
    private BlockingQueue<Number> consumerQue;

    public Consumer(BlockingQueue<Number> consumerQue) {
        this.consumerQue = consumerQue;
    }

    @Override
    public void run() {
        while (true){
            if(consumerQue.isEmpty()){
                System.out.println("***QUE is Empty");
            }else{
                try{
                    Number number = consumerQue.poll(100, TimeUnit.SECONDS);
                    System.out.println(">>>>>>Consumed: "+number);
                    Thread.sleep(150);
                }catch (Exception e){
                    System.out.println("**********Error in Consumer**********");
                }
                finally {

                }

            }

        }
    }
}
