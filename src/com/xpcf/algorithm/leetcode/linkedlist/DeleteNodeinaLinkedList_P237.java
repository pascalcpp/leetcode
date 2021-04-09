package com.xpcf.algorithm.leetcode.linkedlist;

/**
 *
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author XPCF
 * @version 1.0
 * @date 4/9/2021 9:30 PM
 */
public class DeleteNodeinaLinkedList_P237 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
