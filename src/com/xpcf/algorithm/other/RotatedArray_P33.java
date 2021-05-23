package com.xpcf.algorithm.other;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/23/2021 7:59 PM
 */
public class RotatedArray_P33 {
    public static void main(String[] args) {
        RotatedArray_P33 p = new RotatedArray_P33();
        p.search(new int[]{1, 3, 5}, 1);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        if (n == 0) {
            return -1;
        }

        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                // left have order
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
