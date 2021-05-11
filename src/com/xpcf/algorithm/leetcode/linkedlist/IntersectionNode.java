package com.xpcf.algorithm.leetcode.linkedlist;

import java.util.List;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/10/2021 1:10 PM
 */
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA != null) {
                nodeA = nodeA.next;
            } else {
                nodeA = headB;
            }

            if (nodeB != null) {
                nodeB = nodeB.next;
            } else {
                nodeB = headA;
            }
        }

        return nodeA;
    }
}
