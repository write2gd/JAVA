/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.java.test.tc;

/**
 *
 * @author dasg
 */
public class PassByTest {

    public static void tricky(Point arg1, Point arg2, int x) {
        arg1.x = 100;
        arg1.y = 120;
        Point temp = arg1;
        arg1 = arg2;
        arg2 = temp;
        x = 10;
        System.out.println("XX: " + arg1.x + " YY:" + arg1.y);
        System.out.println("XX: " + arg2.x + " YY: " + arg2.y);
        System.out.println("a: " + x);
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Point pnt1 = new Point(10, 20);
        Point pnt2 = new Point(30, 40);
        int a = 5;
        System.out.println("X: " + pnt1.x + " Y: " + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " + pnt2.y);
        System.out.println("a: " + a);
        System.out.println(" ");
        tricky(pnt1, pnt2, a);
        System.out.println("X: " + pnt1.x + " Y:" + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " + pnt2.y);
        System.out.println("a: " + a);
    }

}
