package com.xpcf.algorithm.other;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/21/2021 9:19 PM
 */
public class MoveZeroes {


    public void moveZeroes(int[] nums) {
        int len = nums.length, left = 0, right = 0;

        while (right < len) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                ++left;
            }
            ++right;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
