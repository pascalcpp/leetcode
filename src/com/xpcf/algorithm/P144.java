package com.xpcf.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/1/2021 6:46 AM
 */
public class P144 {

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

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            ans.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }

        }
        return ans;
    }
}
