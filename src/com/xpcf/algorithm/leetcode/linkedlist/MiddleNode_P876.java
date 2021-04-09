package com.xpcf.algorithm.leetcode.linkedlist;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/9/2021 10:49 PM
 */
public class MiddleNode_P876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
