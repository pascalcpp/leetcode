package com.xpcf.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/29/2021 6:52 AM
 */
public class P18 {

    public static void main(String[] args) {
        P18 p = new P18();
        p.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if (nums == null || length == 0) {
            return ans;
        }

        for (int first = 0; first < length - 3; ++first) {
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            for (int second = first + 1; second < length - 2; ++second) {
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int found = target - nums[first] - nums[second];
                // pruning

                int fourth = length - 1;
                for (int third = second + 1; third < length - 1; ++third) {
                    if (third != second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }

                    while (third < fourth && nums[third] + nums[fourth] > found) {
                        --fourth;
                    }
//
//                    while (third < fourth && nums[third] + nums[fourth] < found) {
//                        ++third;
//                    }

                    if (third == fourth) {
                        break;
                    }

                    if (nums[third] + nums[fourth] == found) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        ans.add(list);
                    }

                }

            }
        }

        return ans;

    }


}
