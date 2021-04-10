package com.xpcf.algorithm.leetcode.linkedlist;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/10/2021 11:13 PM
 */
public class MergeTwoLists_p21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1, null);
        ListNode tail = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
            tail = l1;
        }

        if (l2 != null) {
            tail.next = l2;
        }

        return dummyNode.next;
    }

}
