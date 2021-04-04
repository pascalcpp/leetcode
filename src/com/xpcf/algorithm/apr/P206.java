package com.xpcf.algorithm.apr;

import java.util.List;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/4/2021 10:19 AM
 */
public class P206 {

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        reverseList(h);
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }


        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
