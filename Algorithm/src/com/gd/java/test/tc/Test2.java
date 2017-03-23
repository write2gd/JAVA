package com.gd.java.test.tc;

/**
 * Created by dasg on 06-03-2017.
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println("Added= "+test2.add(5,6));

    }
    private long add(long a, long b){
        return a+b;
    }
    private float add(float a, float b){
        return a+b;
    }
     
}
