package com.xpcf.algorithm.leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/17/2021 2:09 PM
 */
public class BalancedBinaryTree_P110 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {

        return height(root) >= 0;

    }


    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
