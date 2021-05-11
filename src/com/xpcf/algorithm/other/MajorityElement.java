package com.xpcf.algorithm.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/11/2021 4:37 PM
 */
public class MajorityElement {


    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            Integer count = map.get(nums[i]);
            if (count != null) {
                map.put(nums[i], count + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }


}
