package com.xpcf.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/30/2021 8:20 AM
 */
public class P15 {

    public static void main(String[] args) {



    }

    public List<List<Integer>> threeSum(int[] nums) {


        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }


        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int first, length = nums.length;
        for (first = 0; first < length - 2; ++first) {

            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first], third = length - 1;
            for (int second = first + 1; second < length - 1; second++) {

                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                if (nums[second] + nums[third] < target) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }

                if (second == third) {
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }

        }

        return ans;
    }

}
