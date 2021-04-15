package com.xpcf.algorithm.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/15/2021 2:42 PM
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(2);
        cache.put(3,3);
    }


    private int capacity;

    private int size = 0;

    private Map<Integer, Node> map;

    private Node head = new Node(-1, -1);

    private Node tail = new Node(-2, -2);

    private class Node {

        Node prev;

        Node next;

        int key;

        int value;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private void init(int capacity) {
        map = new HashMap<Integer, Node>(capacity);

        this.capacity = capacity;

        head.next = tail;

        head.prev = null;

        tail.next = null;

        tail.prev = head;
    }



    public LRUCache(int capacity) {
        init(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        node = new Node(key, value);
        if (size >= capacity) {
            Node temp = tail.prev;
            map.remove(temp.key, temp);
            removeNode(temp);
            --size;
        }

        map.put(key, node);
        addToHead(node);
        ++size;
    }

    private void addToHead(Node node) {

        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;

    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}
