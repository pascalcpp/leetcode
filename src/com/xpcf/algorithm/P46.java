package com.xpcf.algorithm;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/29/2021 12:21 PM
 */
public class P46 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            output.add(nums[i]);
        }
        backTrack(length, output, res, 0);

        return res;
    }

    public void backTrack(int n, List<Integer> output, List<List<Integer>> res, int first) {

        if (first == n - 1) {
            res.add(new ArrayList<>(output));
            return;
        }

        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backTrack(n, output, res, first + 1);
            Collections.swap(output, first, i);
        }
    }

}
