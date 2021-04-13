package com.xpcf.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/12/2021 11:04 PM
 */
public class ImplementQueueUsingStacks_P232 {
    public static void main(String[] args) {


    }

    static class MyQueue {

        private ArrayDeque<Integer> inStack;
        private ArrayDeque<Integer> outStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            checkOutStack();
            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            checkOutStack();
            return outStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void checkOutStack() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }


}
