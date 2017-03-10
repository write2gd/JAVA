/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.java.test;

/**
 *
 * @author dasg
 */
public class Base {
    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("Base.this.x = " + Base.this.x);
        }
    }

    public static void main(String... args) {
        Base st = new Base();
        Base.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}