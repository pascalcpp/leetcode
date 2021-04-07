package com.xpcf.algorithm.swordOffer;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/7/2021 1:35 PM
 */
public class P53 {
    public static void main(String[] args) {
        int[] a = {0, 1};
        System.out.println(missingNumber(a));
    }

    public static int missingNumber(int[] nums) {

        int l = 0, r = nums.length - 1, mid = -1;

        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] > mid) {
                // [l, mid - 1] //
                r = mid - 1;
            } else if (nums[mid] == mid) {
                // [mid + 1, r]
                l = mid + 1;
            }
        }


        return l;
    }
}
