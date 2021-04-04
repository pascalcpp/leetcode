package com.xpcf.algorithm;

import com.sun.deploy.util.ArrayUtil;

import java.io.InputStream;
import java.util.*;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/31/2021 9:59 AM
 */
public class Test {


    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 2}, {2, 3}, {4, 5}};
        System.out.println(ints[2][0]);
    }


    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }


}
