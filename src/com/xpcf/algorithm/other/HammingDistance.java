package com.xpcf.algorithm.other;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/13/2021 7:55 PM
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int ans = 0;

        while (n != 0) {
            if ((1 & n) == 1) {
                ++ans;
            }
            n >>>= 1;
        }

        return ans;
    }
}
