/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dasg
 */
public class BinarySearch {

    private BinarySearch() {
    }

    public static int indexOf(Object[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < (int) a[mid]) {
                hi = mid - 1;
            } else if (key > (int) a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = 1;
        List<Integer> input = new ArrayList<>();
        while (num > -999) {
            num = sc.nextInt();
            input.add(num);
        }
        // sort the array
        Collections.sort(input);
        System.out.println("Input=" + input);
        Object[] in = input.toArray();
        System.out.println("Enter a number to search: ");
        num = sc.nextInt();
        int result = BinarySearch.indexOf(in, num);
        if (result == -1) {
            System.out.println(num + "Not found");
        } else {
            System.out.println(num + " found at " + result);
        }
    }
}
