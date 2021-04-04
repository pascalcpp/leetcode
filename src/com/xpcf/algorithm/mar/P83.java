package com.xpcf.algorithm.mar;

/**
 *
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 38 MB
 * , 在所有 Java 提交中击败了
 * 33.74%
 * 的用户
 * @author XPCF
 * @version 1.0
 * @date 3/26/2021 3:22 AM
 */
public class P83 {
    public static void main(String[] args) {
        P83 p83 = new P83();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        p83.deleteDuplicates(head);

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode next, lNode, dummyNode = new ListNode(1024, head);
        next = dummyNode;

        while (next.next != null) {
            lNode = next;
            next = next.next;

            if (lNode.val == next.val) {
                while (lNode.val == next.val) {
                    next = next.next;
                    if (next == null) {
                        lNode.next = null;
                        return dummyNode.next;
                    }
                }
                lNode.next = next;

            }


        }

        return dummyNode.next;

    }
}
