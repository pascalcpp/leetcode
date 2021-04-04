package com.xpcf.algorithm.mar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/3/2021 9:46 AM
 */
public class P102 {
    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            TreeNode first = null;
            int size = queue.size();

            for (int i = 0; i < size; ++i) {

                first = queue.remove();
                list.add(first.val);

                if (first.left != null) {
                    queue.add(first.left);
                }

                if (first.right != null) {
                    queue.add(first.right);
                }

            }

            ans.add(list);
        }
        return ans;
    }



}
