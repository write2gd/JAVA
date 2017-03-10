package com.gd.java.test.tc;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * Created by dasg on 06-03-2017.
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Time time = new Time(00,00,00);
        System.out.println("Returned : "+time);
        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        try {
            Date date = sdf.parse("01:54:04");
            System.out.println("Returned : "+date.getTime());
            System.out.println(date.before(time));
        }catch (Exception e){

        }


        int a = test1.checkException();
        System.out.println("Returned : "+a);
    }

    private  int checkException() {
        try{
            System.out.println("XXXX");
            //System.exit(0);
            throw new IOException();
        }catch (Exception e){
            System.out.println("YYYYY");
            System.exit(0);
            throw new IOException();
        }finally {
            System.out.println("ZZZZZZ");
           // System.exit(0);
            return 3;
        }
       // return 1;
    }
}
