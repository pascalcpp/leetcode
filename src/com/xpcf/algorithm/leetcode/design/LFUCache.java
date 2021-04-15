package com.xpcf.algorithm.leetcode.design;

import com.xpcf.algorithm.apr.P20;

import javax.xml.bind.annotation.XmlID;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/15/2021 5:37 PM
 */
public class LFUCache {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.get(2);
    }

    private int minFreq;

    private int capacity;

    private Map<Integer, Node> keyTable;

    private Map<Integer, LinkedList<Node>> freqTable;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyTable = new HashMap<>();
        freqTable = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }

        if (!keyTable.containsKey(key)) {
            return -1;
        }

        Node node = keyTable.get(key);
        int freq = node.freq, value = node.val;
        freqTable.get(freq).remove(node);

        if (freqTable.get(freq).size() == 0) {
            freqTable.remove(freq);
            if (freq == minFreq) {
                ++minFreq;
            }
        }

        LinkedList<Node> list = freqTable.getOrDefault(freq + 1, new LinkedList<>());
        node.freq = freq + 1;
        list.offerFirst(node);
        freqTable.put(freq + 1, list);
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (!keyTable.containsKey(key)) {
            if (keyTable.size() == capacity) {
                Node node = freqTable.get(minFreq).pollLast();
                keyTable.remove(node.key);
                if (freqTable.get(minFreq).size() == 0) {
                    freqTable.remove(minFreq);
                }
            }
            LinkedList<Node> list = freqTable.getOrDefault(1, new LinkedList<>());
            list.offerFirst(new Node(key, value, 1));
            freqTable.put(1, list);
            keyTable.put(key, list.getFirst());
            minFreq = 1;
        } else {

            Node node = keyTable.get(key);
            node.val = value;
            int freq = node.freq;
            freqTable.get(freq).remove(node);

            if (freqTable.get(freq).size() == 0) {
                freqTable.remove(freq);
                if (freq == minFreq) {
                    ++minFreq;
                }
            }

            LinkedList<Node> list = freqTable.getOrDefault(freq + 1, new LinkedList<>());
            node.freq = freq + 1;
            list.offerFirst(node);
            freqTable.put(freq + 1, list);
            keyTable.put(key, node);
        }
    }

    class Node {
        int key, val, freq;

        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }
}


