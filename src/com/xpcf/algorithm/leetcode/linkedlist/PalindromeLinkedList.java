package com.xpcf.algorithm.leetcode.linkedlist;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/11/2021 4:53 PM
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        PalindromeLinkedList p = new PalindromeLinkedList();
        p.isPalindrome(head);
    }
    public boolean isPalindrome(ListNode head) {

        int n = 0;
        ListNode node = head;
        while (node != null) {
            ++n;
            node = node.next;
        }

        ListNode head2 = null;
        int rMid;
        node = head;
        if ((n & 1) == 0) {
            rMid = n / 2;
            n = 0;
            while (n != rMid) {
                ++n;
                node = node.next;
            }
            head2 = reverseLinkedList(node);
        } else {
            rMid = n / 2 + 1;
            n = 0;
            while (n != rMid) {
                ++n;
                node = node.next;
            }
            head2 = reverseLinkedList(node);
        }
        node = head;
        boolean result = true;
        while (head2 != null && result) {
            if (node.val != head2.val) {
                result = false;
            }
            node = node.next;
            head2 = head2.next;
        }

        return result;
    }

    private ListNode reverseLinkedList(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
