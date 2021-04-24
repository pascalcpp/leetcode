package com.xpcf.algorithm.leetcode.set;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/24/2021 11:31 PM
 */
public class Intersection {


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        int l1 = nums1.length, l2 = nums2.length;
        for (int i = 0; i < l1; i++) {
            s1.add(nums1[i]);
        }
        for (int i = 0; i < l2; i++) {
            s2.add(nums2[i]);
        }
        List<Integer> ans = new ArrayList<>();
        if (s1.size() < s2.size()) {
            for (Integer val : s1) {
                if (s2.contains(val)) {
                    ans.add(val);
                }
            }
        } else {
            for (Integer val : s2) {
                if (s1.contains(val)) {
                    ans.add(val);
                }
            }
        }
        int[] arr = new int[ans.size()];
        int index = 0;
        for (Integer val : ans) {
            arr[index++] = val;
        }
        return arr;
    }
}
