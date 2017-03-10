package com.gd.java.test.tc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by dasg on 07-03-2017.
 */
public class Pair {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        findpir(input, 17);
       

    }

    private static void findpir(int[] input, int number) {
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
        for (int i = 0; i < input.length; i++) {
            if (pairs.containsKey(input[i])) {
                System.out.println(input[i] + ", " + pairs.get(input[i]));
            } else {
                pairs.put(number - input[i], input[i]);
            }
        }
    }
}
