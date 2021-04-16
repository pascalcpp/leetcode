package com.xpcf.algorithm.leetcode.binarytree;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/15/2021 9:29 PM
 */
public class Flatten_P114 {

    public void flatten(TreeNode root) {
        
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode left = cur.left;
                TreeNode predecessor = left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = cur.right;
                cur.right = left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }



}
