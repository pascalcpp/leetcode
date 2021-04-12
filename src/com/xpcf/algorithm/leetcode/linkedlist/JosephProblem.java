package com.xpcf.algorithm.leetcode.linkedlist;

import com.xpcf.algorithm.util.SingleCircleLinkedList;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/10/2021 11:04 PM
 */
public class JosephProblem {


    public static void main(String[] args) throws InterruptedException {

        SingleCircleLinkedList<Integer> list = new SingleCircleLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);

        list.reset();
        int n = 8;
        while (n-- > 0) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
        Node[] ars = new Node[10];

        System.out.println("-----------");
//        josephWithLinkedList();
        int f = f(8, 3);
        System.out.println("------------");
        System.out.println(f);
    }

    static int f(int n, int m){
        if(n == 1)   return n;
        int r = (f(n - 1, m) + m - 1) % n + 1;
        System.out.println(r);
        return r;
    }

    int f2(int n, int m){
        return n == 1 ? n : (f2(n - 1, m) + m - 1) % n + 1;
    }


    public static void josephWithLinkedList() {
        // create Linked list
        Node<Integer> head = new Node<>(1);
        Node<Integer> next = head;
        for (int i = 0; i < 7; i++) {
            next.next = new Node<>(i + 2);
            next = next.next;
        }
        next.next = head;

        next = head;
        int count = 1, m = 3;
        Node<Integer> prev = null;
        while (next != next.next) {
            if (count == m) {
                count = 1;
                System.out.println(next.element);
                prev.next = next.next;
                next = prev.next;
            } else {
                ++count;
                prev = next;
                next = next.next;
            }
        }
        System.out.println(next.element);
    }

    static class Node<E> {
        E element;
        Node<E> next;

        Node() {

        }

        Node(E element) {
            this.element = element;
        }
    }

    public static void joseph() {
        int[] arr = new int[50];
        int n = 8, m = 3;

//        initialize
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int dead = 0, cur = 0, count = 0;
        while (dead < 8) {

            if (arr[cur] != 0) {
                ++count;
                if (count == 3) {
                    count = 0;
                    arr[cur] = 0;
                    System.out.println(cur + 1);
                    ++dead;
                }
            }
//            if (++cur > 7) {
//                cur = 0;
//            }
            cur = ++cur & 7;

        }

    }

}
