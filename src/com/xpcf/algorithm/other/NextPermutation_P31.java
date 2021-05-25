package com.xpcf.algorithm.other;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/21/2021 6:27 PM
 */
public class NextPermutation_P31 {

    public static void main(String[] args) {


    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i > -1 && nums[i] >= nums[i + 1]) {
            --i;
        }

        if (i > -1) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                --j;
            }
            // swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        //reverse
        ++i;
        int j = nums.length - 1;
        int temp;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            --j;
            ++i;
        }
    }


}
