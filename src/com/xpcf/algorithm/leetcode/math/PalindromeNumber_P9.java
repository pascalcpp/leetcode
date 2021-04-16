package com.xpcf.algorithm.leetcode.math;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/16/2021 5:15 PM
 */
public class PalindromeNumber_P9 {

    public static void main(String[] args) {
        isPalindrome(121);
    }

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverseNumber = 0;

        while (reverseNumber < x) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }

        return reverseNumber == x || reverseNumber / 10 == x;
    }
}
