package com.xpcf.algorithm.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/15/2021 7:53 PM
 */
public class BuildTree_P105 {

    int[] preorder;
    int[] inorder;
    int preIdx;
    int len;
    Map<Integer, Integer> dict;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        dict = new HashMap<>();
        this.preorder = preorder;
        this.inorder = inorder;
        len = preorder.length;
        preIdx = 0;
        for (int i = 0; i < len; i++) {
            dict.put(inorder[i], i);
        }
        return createTree(0, len - 1);
    }

    private TreeNode createTree(int iL, int iR) {
        if (iL > iR) {
            return null;
        }

        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = dict.get(rootVal);
        ++preIdx;
        root.left = createTree(iL, index - 1);
        root.right = createTree(index + 1, iR);
        return root;
    }

}
