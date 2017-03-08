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
public class Insertion {

    private Insertion() {
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        int exchanges = 0;
        for (int i = n - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                exch(a, i, i - 1);
                exchanges++;
            }
        }
        if (exchanges == 0) {
            return;
        }
        for (int i = 2; i < n; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = v;
        }

        assert isSorted(a);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private static void show(Comparable[] a) {
        for (Comparable a1 : a) {
            StdOut.println(a1);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {8, 6, 4, 1, 9, 2, 3, 0, 9, 5, 3, 7};
        Insertion.sort(a);
        show(a);
    }

}
