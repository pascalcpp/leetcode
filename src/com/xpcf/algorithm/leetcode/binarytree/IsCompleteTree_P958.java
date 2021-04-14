package com.xpcf.algorithm.leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/14/2021 9:28 PM
 */
public class IsCompleteTree_P958 {
    public static void main(String[] args) {

    }

    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(leaf && !(node.left == null && node.right == null)) {
                return false;
            }

            //
            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                leaf = true;
            }
        }

        return true;
    }
}
