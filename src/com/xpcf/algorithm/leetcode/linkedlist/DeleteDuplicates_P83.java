package com.xpcf.algorithm.leetcode.linkedlist;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/9/2021 10:44 PM
 */
public class DeleteDuplicates_P83 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {

            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
