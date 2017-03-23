/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.java.test.tc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author dasg
 */
public class MapDemo {

    public static void main(String[] args) {
        Map<String, String> beforeMap = new HashMap<>();
        beforeMap.put("a", "1");
        beforeMap.put("b", "2");
        beforeMap.put("c", "3");

        Map<String, String> afterMap = new HashMap<>();
        afterMap.put("a", "1");
        afterMap.put("c", "333");

        System.out.println("Before " + beforeMap);
        System.out.println("After " + afterMap);
        System.out.println("***********************************");
        Set<String> removedKeys = new HashSet<>(beforeMap.keySet());
        removedKeys.removeAll(afterMap.keySet());

        Set<String> addedKeys = new HashSet<>(afterMap.keySet());
        addedKeys.removeAll(beforeMap.keySet());

        Set<Entry<String, String>> changedEntries = new HashSet<>(afterMap.entrySet());
        changedEntries.removeAll(beforeMap.entrySet());

        System.out.println("added " + addedKeys);
        System.out.println("removed " + removedKeys);
        System.out.println("changed " + changedEntries);

    }

}
