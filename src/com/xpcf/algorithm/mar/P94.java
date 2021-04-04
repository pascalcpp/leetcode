package com.xpcf.algorithm.mar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/2/2021 12:41 PM
 */
public class P94 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            ans.add(root.val);
            root = root.right;

        }

        return ans;
    }
}
