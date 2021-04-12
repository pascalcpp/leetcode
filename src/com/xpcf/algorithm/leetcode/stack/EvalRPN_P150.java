package com.xpcf.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/12/2021 4:30 PM
 */
public class EvalRPN_P150 {

    public static void main(String[] args) {
        String[] arr = {"3","-4","+"};
        System.out.println(evalRPN(arr));
    }


    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            int n1, n2;
            if (tokens[i].equals("*")) {
                n1 = stack.pop();
                n2 = stack.pop();
                stack.push(n2 * n1);
            } else if (tokens[i].equals("/")) {
                n1 = stack.pop();
                n2 = stack.pop();
                stack.push(n2 / n1);
            } else if (tokens[i].equals("+")) {
                n1 = stack.pop();
                n2 = stack.pop();
                stack.push(n2 + n1);
            } else if (tokens[i].equals("-")) {
                n1 = stack.pop();
                n2 = stack.pop();
                stack.push(n2 - n1);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }


        }

        return stack.pop();
    }

}
