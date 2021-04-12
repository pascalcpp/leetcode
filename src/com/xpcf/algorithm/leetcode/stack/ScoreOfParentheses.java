package com.xpcf.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/11/2021 11:12 PM
 */
public class ScoreOfParentheses {



    public int scoreOfParentheses(String S) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int len = S.length();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == '(') {
                stack.push(0);
            } else {
                Integer p1 = stack.pop();
                Integer p2 = stack.pop();
                stack.push(p2 + Math.max(p1 << 1, 1));
            }
        }


        return stack.pop();
    }
}
