package com.xpcf.algorithm.apr;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/9/2021 12:27 PM
 */
public class P50 {
    public static void main(String[] args) {

    }


    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long)n);
    }

    public double quickMul(double x, long n) {
        double ans = 1.0;

        while (n > 0) {

            if ((n & 1) == 1) {
                ans *= x;
            }

            x *= x;
            n >>= 1;
        }

        return ans;
    }
}
