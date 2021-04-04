package com.xpcf.algorithm.mar;

/**
 * @author xpcf
 *
 *
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 38 MB
 * , 在所有 Java 提交中击败了
 * 33.60%
 * 的用户
 */
public class P82 {
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(1);
//        n.next.next = new ListNode(3);
//        n.next.next.next = new ListNode(4);
//        n.next.next.next.next = new ListNode(4);
//        n.next.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        solution.deleteDuplicates(n);

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

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            ListNode dummyNode = new ListNode(1024, head);
            ListNode next = dummyNode;
            ListNode sentinel = dummyNode.next;

            while (((next = next.next) != null) && (next.next != null)) {
                if (next.val == next.next.val) {

                    if (dummyNode.next == next) {
                        while (next.next.val == next.val) {
                            next = next.next;
                            if (next.next == null) {
                                break;
                            }
                        }
                        dummyNode.next = next.next;
                        sentinel = next.next;

                    } else {
                        while (next.next.val == next.val) {
                            next = next.next;
                            if (next.next == null) {
                                break;
                            }
                        }

                        sentinel.next = next.next;
                    }

                } else {
                    sentinel = next;
                }
            }




            return dummyNode.next;
        }


    }
}
