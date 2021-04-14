package com.xpcf.algorithm.leetcode.binarytree;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/14/2021 10:50 PM
 */
//public class Predecessor {
//
//
//    private void checkNullPointer(TreeNode node) {
//        if (node == null) {
//            throw new NullPointerException("TreeNode cant be null");
//        }
//    }
//
//    public TreeNode Predecessor(TreeNode node) {
//        checkNullPointer(node);
//        if (node.left != null) {
//            node = node.left;
//            while (node.right != null) {
//                node = node.right;
//            }
//            return node;
//        }
//
//        while (node.parent != null && node.parent.left == node) {
//            node = node.parent;
//        }
//
//        return node.parent;
//    }
//
//    public TreeNode successor(TreeNode node) {
//        checkNullPointer(node);
//        if (node.right != null) {
//            node = node.right;
//
//            while (node.left != null) {
//                node = node.left;
//            }
//
//            return node;
//        }
//
//        while (node.parent != null && node == node.parent.right) {
//            node = node.parent;
//        }
//        return node.parent;
//    }
//}
