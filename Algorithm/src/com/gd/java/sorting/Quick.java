/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.java.sorting;

import com.gd.java.StdOut;

/**
 *
 * @author dasg
 */
public class Quick { 
    private Quick() { }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);       
    }

    private static void sort(Comparable[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);        
    }
private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) { 
       while (less(a[++i], v))
                if (i == hi) break;
      while (less(v, a[--j]))
                if (j == lo) break;      
       if (i >= j) break;

            exch(a, i, j);
        }
    exch(a, lo, j);
      return j;
    }

    public static Comparable select(Comparable[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }       
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(Comparable[] a) {
        for (Comparable a1 : a) {
            StdOut.println(a1);
        }
    }


    public static void main(String[] args) {
        Integer[] a = {8, 6, 4, 1, 9, 2, 3, 0, 9, 5, 3, 7};
        Quick.sort(a);
        show(a);
    }

}
