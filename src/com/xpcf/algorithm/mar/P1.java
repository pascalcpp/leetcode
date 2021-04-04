package com.xpcf.algorithm.mar;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/29/2021 7:10 AM
 */
public class P1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer temp;
        for (int i = 0; i < nums.length; i++) {

            if ((temp = map.get(target - nums[i])) != null) {
                return new int[]{temp, i};
            }
            map.put(nums[i], i);

        }
        return null;
    }

}
