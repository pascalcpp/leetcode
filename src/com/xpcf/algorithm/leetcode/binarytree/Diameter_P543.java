package com.xpcf.algorithm.leetcode.binarytree;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/15/2021 10:56 PM
 */
public class Diameter_P543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }


}
