package com.xpcf.algorithm.mar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/1/2021 6:46 AM
 */
public class P144 {

    public static void main(String[] args) throws InterruptedException {



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

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        return ans;
    }
}
