package com.xpcf.algorithm.leetcode.binarytree;

import com.xpcf.algorithm.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/14/2021 9:03 PM
 */
public class MaxDepth_P104 {


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();

        deque.offer(root);
        int levelSize = 1;
        int height = 0;

        while (!deque.isEmpty()) {

            TreeNode node = deque.poll();
            --levelSize;

            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }

            if (levelSize == 0) {
                ++height;
                levelSize = deque.size();
            }
        }
        return height;
    }
}
