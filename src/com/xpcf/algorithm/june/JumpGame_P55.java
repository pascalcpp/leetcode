package com.xpcf.algorithm.june;

/**
 * @author XPCF
 * @version 1.0
 * @date 6/3/2021 10:03 PM
 */
public class JumpGame_P55 {

    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int jumpIndex = nums[i] + i;
            if (jumpIndex > maxIndex) {
                maxIndex = jumpIndex;
            }
        }
        return maxIndex == n - 1;
    }

}
