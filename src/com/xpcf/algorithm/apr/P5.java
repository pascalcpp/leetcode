package com.xpcf.algorithm.apr;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/5/2021 10:12 AM
 */
public class P5 {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {

        int len = s.length();
        int max = 0, l = 0, r = 0;
        boolean[][] dp = new boolean[len + 1][len + 1];


        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && (i - j < 3 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j > max - 1) {
                        max = i - j + 1;
                        l = j;
                        r = i;
                    }
                }
            }
        }



        return s.substring(l - 1, r);
    }
}
