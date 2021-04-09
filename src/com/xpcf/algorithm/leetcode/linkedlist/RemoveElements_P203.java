package com.xpcf.algorithm.leetcode.linkedlist;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/9/2021 10:23 PM
 */
public class RemoveElements_P203 {
    public static void main(String[] args) {


    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1 ,head);
        ListNode next = head;
        ListNode prev = dummyNode;
        while (next != null) {

            if (next.val == val) {
                prev.next = next.next;
            } else {
                prev = next;
            }
            next = next.next;

        }

        return dummyNode.next;
    }
}
