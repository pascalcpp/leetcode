package com.xpcf.algorithm.leetcode.binarytree;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/15/2021 9:29 PM
 */
public class Flatten_P114 {

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }



}
