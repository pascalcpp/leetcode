package com.xpcf.algorithm.leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/16/2021 5:07 PM
 */
public class SymmetricTree_P101 {



    public boolean isSymmetric(TreeNode root) {

        return check(root,  root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && check(left.right, right.left) && check(left.left, right.right);
    }






}
