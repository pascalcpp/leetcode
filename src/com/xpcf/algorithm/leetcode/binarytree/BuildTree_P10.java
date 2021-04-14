package com.xpcf.algorithm.leetcode.binarytree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/14/2021 11:22 PM
 */
public class BuildTree_P10 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public static void main(String[] args) {

    }

    int[] inorder, postorder;
    int postIdx;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.inorder = inorder;
        this.postorder = postorder;
        int len = postorder.length;
        postIdx = len - 1;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        return createTree(0, len - 1);

    }

    public TreeNode createTree(int left, int right) {

        if (left > right) {
            return null;
        }

        int rootVal = postorder[postIdx];
        TreeNode node = new TreeNode(rootVal);
        int index = map.get(rootVal);

        --postIdx;
        node.right = createTree(index + 1, right);
        node.left = createTree(left, index - 1);

        return node;
    }



}
