package com.xpcf.algorithm.apr;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/7/2021 12:12 PM
 */
public class P34 {
    public static void main(String[] args) {
        P34 p = new P34();
        int[] ints = {5, 7, 7, 8, 8, 10};
        int[] a = null;
        for (int i : p.searchRange(null, 6)) {
            System.out.println(i);
        }
    }


    public int[] searchRange(int[] nums, int target) {

        int len;
        int[] ans = {-1, -1};

        if (nums == null || (len = nums.length) == 0) {
            return ans;
        }

        int l = 0, r = len - 1, mid = -1;

        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {

                l = r = mid;

                while (l > -1 && nums[l] == target) {
                    --l;
                }
                while (r < len && nums[r] == target) {
                    ++r;
                }
                ans[0] = l + 1;
                ans[1] = r - 1;
                return ans;
            }
        }


        return ans;
    }


}
