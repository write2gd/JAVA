package com.gd.java.test.pc.gt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dasg on 03-03-2017.
 */
public class MainClass {
    private static BlockingQueue<Number> sharedResource = new LinkedBlockingQueue<Number>(10) ;

    public static void main(String[] args) {
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);
        Thread producerThread = new Thread(producer,"Producer Thread");
        Thread consumerThread = new Thread(consumer,"Consumer Thread");
        producerThread.start();
        consumerThread.start();
    }

}
