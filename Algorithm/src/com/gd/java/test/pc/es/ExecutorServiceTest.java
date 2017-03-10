package com.gd.java.test.pc.es;

import java.lang.reflect.Array;
import java.util.concurrent.*;

/**
 * Created by dasg on 03-03-2017.
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {
      final  int[] test = {1,2,3,4};
        ExecutorService es = Executors.newFixedThreadPool(2);
      Future res1=es.submit(new Callable<Integer>() {

           @Override
           public Integer call() throws Exception {
               return test[0]+test[1];
           }
       });

        Future res2=es.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return test[2]+test[3];
            }
        });
        try {
            Thread.sleep(5000);
            System.out.println("Res1= "+res1.get()+" Res2 = "+res2.get()+" Result = "+res1.get()+res2.get());
        }catch (Exception e){}

        es.shutdown();
    }
}
