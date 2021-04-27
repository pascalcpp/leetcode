package com.xpcf.algorithm.other;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/26/2021 11:36 PM
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
