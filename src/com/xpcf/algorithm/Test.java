package com.xpcf.algorithm;


import com.xpcf.algorithm.util.SingleCircleLinkedList;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/31/2021 9:59 AM
 */
public class Test {

    public static final ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();

    public static final ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();


    public static void main(String[] args) {


    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public static class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        int levelSize = 1;
        List<Integer> levelList = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            levelList.add(node.val);
            --levelSize;
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
            if (levelSize == 0) {
                ans.add(levelList);
                levelList = new ArrayList<>();
                levelSize = deque.size();
            }
        }
        return ans;
    }


}
