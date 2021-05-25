package com.xpcf.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/25/2021 11:46 PM
 */
public class CombinationSum_P39 {

    public static void main(String[] args) {
        CombinationSum_P39 p = new CombinationSum_P39();
        p.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(p.ans);
    }

    private int[] candidates;
    private int size;
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.size = candidates.length;
        this.ans = new ArrayList<>();
        backTrackToSum(new ArrayList<>(), target, 0);
        return ans;
    }

    private void backTrackToSum(List<Integer> combination, int curSum, int idx) {
        if (idx == size) {
            return;
        }
        backTrackToSum(combination, curSum, idx + 1);

        int nextSum = curSum - candidates[idx];

        if (nextSum > 0) {
            combination.add(candidates[idx]);
            backTrackToSum(combination, nextSum, idx);
            combination.remove(combination.size() - 1);
        }
        if (nextSum == 0) {
            combination.add(candidates[idx]);
            ans.add(new ArrayList<>(combination));
            combination.remove(combination.size() - 1);
        }
    }
}
