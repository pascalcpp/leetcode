package com.xpcf.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/12/2021 6:27 PM
 */
public class BasicCalculator_P224 {
    public static void main(String[] args) {

        System.out.println(calculate("2147483647"));
    }

    public static int calculate(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int ans = 0, sign = 1;
        for (int i = 0; i < len; i++) {


            // use switch to optimize
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                stack.push(sign);
            } else if (ch == '-') {
                sign = -stack.peek();
            } else if (ch == '+') {
                sign = stack.peek();
            } else if (ch == ')') {
                stack.pop();
            } else {

                int j = i;
                int num = 0;
                while (j < len && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + s.charAt(j) - '0';
                    ++j;
                }
                i = j - 1;
                ans += sign * num;
            }
        }
        return ans;
    }
}
