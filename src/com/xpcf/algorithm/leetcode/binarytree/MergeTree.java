package com.xpcf.algorithm.leetcode.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/16/2021 8:01 PM
 */
public class MergeTree {


    public static void main(String[] args) {
        List<Integer> stepSequence = new LinkedList<>();
        int k = 0, step = 0;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }

            if (step >= 30000) break;
            stepSequence.add(0, step);
            k++;
        }
        System.out.println(stepSequence);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode mergeNode = new TreeNode(root1.val + root2.val);
        mergeNode.left = mergeTrees(root1.left, root2.left);
        mergeNode.right = mergeTrees(root1.right, root2.right);
        return mergeNode;
    }

}
