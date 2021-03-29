package com.xpcf.algorithm;

/**
 *
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 51.22%
 * 的用户
 * 内存消耗：
 * 38.2 MB
 * , 在所有 Java 提交中击败了
 * 5.01%
 * 的用户
 *
 * @author XPCF
 * @version 1.0
 * @date 3/27/2021 2:00 PM
 */
public class P61 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        P61 p = new P61();
        p.rotateRight(head, 0);
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode next = head;
        ListNode last = head, first = head;
        int iter, length = 1;
        while ((next = next.next) != null) {
            last = next;
            ++length;
        }
        k %= k;
        last.next = first;

        while (k-- > 0) {
            first = last;
            next = first;
            iter = length;
            while (iter-- > 0) {
                last = next;
                next = next.next;
            }
        }

        last.next = null;


        return first;
    }

    public ListNode standardAns(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;

    }



}
