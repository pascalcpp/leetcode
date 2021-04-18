package com.xpcf.algorithm.leetcode.binarytree;

import java.util.*;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/18/2021 11:24 PM
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int levelSize = deque.size();
        List<Integer> levelList = new ArrayList<>();
        while(!deque.isEmpty()) {

            TreeNode node = deque.poll();
            levelList.add(node.val);
            --levelSize;
            if (node.left != null) {
                deque.offer(node.left);
            }


            if (node.right != null) {
                deque.offer(node.right);
            }

            if (levelSize == 0) {
                ans.add(0, levelList);
                levelSize = deque.size();
                levelList = new ArrayList<>();
            }

        }
        return ans;
    }

}
