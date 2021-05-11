package com.xpcf.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/10/2021 1:01 PM
 */
public class MinStack_P155 {

    static class MinStack {

        Deque<Integer> minStack;
        Deque<Integer> stack;
        /** initialize your data structure here. */
        public MinStack() {
            init();
        }


        private void init() {
            minStack = new ArrayDeque<>();
            stack = new ArrayDeque<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(val < minStack.peek() ? val : minStack.peek());
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

    }
}
