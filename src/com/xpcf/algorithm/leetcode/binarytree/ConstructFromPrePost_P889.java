package com.xpcf.algorithm.leetcode.binarytree;

import java.util.Arrays;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/15/2021 8:24 PM
 */
public class ConstructFromPrePost_P889 {
    public static void main(String[] args) {
        int[] a1 = {1,2};
        int[] a2 = {2,1};
        constructFromPrePost(a1, a2);


    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {

        int len = pre.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (len == 1) {
            return root;
        }
        int l = 0;
        for (int i = 0; i < len; i++) {
            if (post[i] == pre[1]) {
                l = i + 1;
                break;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, l + 1), Arrays.copyOfRange(post, 0, l));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, l + 1, len), Arrays.copyOfRange(post, l, len));
        return root;
    }

}
