package com.xpcf.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/29/2021 6:52 AM
 */
public class P18 {

    public static void main(String[] args) {
//        P18 p = new P18();
//        p.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);


        String s = " sadasdas";
//        int[] a = {1, 2, 3};
//
//        ArrayList<Object> list = new ArrayList<>();
//        Iterator<Object> iterator = list.iterator();
//
//        List<Integer> collect = Arrays.stream(a).boxed().collect(Collectors.toList());
//        Integer[] integers = collect.toArray(new Integer[0]);
//        System.out.println();

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
            if (nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }

            if (nums[first] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }


            for (int second = first + 1; second < length - 2; ++second) {
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                if (nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                    break;
                }

                if (nums[first] + nums[second] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }

                int fourth = length - 1;
                int third = second + 1;
                while (third < fourth) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        while (third < fourth && nums[third] == nums[third + 1]) {
                            ++third;
                        }
                        ++third;

                        while (third < fourth && nums[fourth] == nums[fourth - 1]) {
                            --fourth;
                        }
                        --fourth;


                    } else if (sum < target) {
                        ++third;
                    } else {
                        --fourth;
                    }
                }
            }
        }

        return ans;

    }


}
