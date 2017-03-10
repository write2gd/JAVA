package com.gd.java.test.gt.pc.gt2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dasg on 03-03-2017.
 */
public class MainClass {
    private static Queue<Number> sharedResource = new LinkedList<Number>() ;
    public static AtomicInteger sim =new AtomicInteger();

    public static void main(String[] args) {
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);
        Thread producerThread = new Thread(producer,"Producer Thread");
        Thread consumerThread = new Thread(consumer,"Consumer Thread");
        producerThread.start();
        consumerThread.start();
    }

}

