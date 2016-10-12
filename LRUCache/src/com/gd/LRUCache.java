/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd;

/**
 *
 * @author dasg
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }

    public static void main(String args[]) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(5);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(1, 4);
        lruCache.put(5, 6);
        lruCache.put(2, 5);
        lruCache.put(7, 6);

        System.out.println("LRU Cache Key Sets: " + lruCache.keySet());

        lruCache.put(1, 4);
        lruCache.put(2, 5);

        System.out.println("LRU Cache Key Sets After Insertion: " + lruCache.keySet());
    }

}
