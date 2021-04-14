package com.xpcf.algorithm.leetcode.binarytree;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/14/2021 10:50 PM
 */
public class Predecessor {


    public TreeNode Predecessor(TreeNode node) {
        if (node.left != null) {
            node = node.left;
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }

        while (node.parent != null && node.parent.left == node) {
            node = node.parent;
        }

        return node.parent;
    }

    public TreeNode successor(TreeNode node) {

        if (node.right != null) {
            node = node.right;

            while (node.right != null) {
                node = node.right;
            }

            return node;
        }

        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }
}
