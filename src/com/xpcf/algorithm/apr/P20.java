package com.xpcf.algorithm.apr;

import java.util.Stack;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/5/2021 11:17 AM
 */
public class P20 {

    public static void main(String[] args) {
        P20 p = new P20();
        System.out.println(p.isValid("()"));
    }

    public boolean isValid(String s) {

        int len = s.length();
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {

                if (stack.isEmpty() || !chooseBracket(s.charAt(i), stack.pop())) {
                    return false;
                }

            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean chooseBracket(char c, char top) {
        switch (top) {
            case '(':
                return ')' == c;
            case '[':
                return ']' == c;
            case '{':
                return '}' == c;
        }
        return false;
    }

}
