/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.java.sorting;

import com.gd.java.StdOut;
import java.util.Comparator;

/**
 *
 * @author dasg
 */
public class Selection {
   private Selection() { }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);           
        }        
    }

    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(comparator, a[j], a[min])) min = j;
            }
            exch(a, i, min);            
        }        
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }
        
  
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
        Selection.sort(a);
        show(a);
    }
}
