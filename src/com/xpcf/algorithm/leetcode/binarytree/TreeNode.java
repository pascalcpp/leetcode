package com.xpcf.algorithm.leetcode.binarytree;

import com.xpcf.algorithm.Test;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/14/2021 9:03 PM
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

