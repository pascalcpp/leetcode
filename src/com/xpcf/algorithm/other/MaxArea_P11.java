package com.xpcf.algorithm.other;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/18/2021 8:18 PM
 */
public class MaxArea_P11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int lV = height[l], rV = height[r];
            if (lV < rV) {
                ans = Math.max(ans, (r - l) * lV);
                ++l;
            } else {
                ans = Math.max(ans, (r - l) * rV);
                --r;
            }

        }
        return ans;
    }
}
