package com.xpcf.algorithm.apr;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/6/2021 10:27 AM
 */
public class P19 {


    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next = head;
        int len = 0;
        while (next != null) {
            ++len;
            next = next.next;
        }

        n = len - n + 1;
        len = 0;
        next = head;
        ListNode prev = null;
        while (next != null) {
            if (++len == n) {

                if (n == 1) {
                    head = head.next;
                    break;
                } else {
                    prev.next = next.next;
                    break;
                }

            }
            prev = next;
            next = next.next;
        }
        return head;
    }



    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
