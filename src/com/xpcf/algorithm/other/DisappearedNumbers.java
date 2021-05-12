package com.xpcf.algorithm.other;

import java.util.*;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/12/2021 9:06 PM
 */
public class DisappearedNumbers {
    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

}
