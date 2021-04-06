package com.xpcf.algorithm.apr;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/6/2021 10:56 AM
 */
public class P70 {
    public static void main(String[] args) {

        P70 p = new P70();
        System.out.println(p.climbStairs(3));
    }



    public int climbStairs(int n) {

        int[][] dp = new int[3][n + 1];
        dp[1][1] = 1;
        dp[2][1] = 0;

        if (n > 1) {
            dp[1][2] = 1;
            dp[2][2] = 1;
        }

        for (int i = 3; i < n + 1; i++) {
            dp[1][i] = dp[1][i - 1] + dp[2][i - 1];
            dp[2][i] = dp[1][i - 2] + dp[2][i - 2];
        }
        return dp[1][n] + dp[2][n];
    }


    public int climbStairs2(int n) {
        int p = 1, q = 1, r = 2;
        for (int i = 3; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


}
