package com.xpcf.algorithm.other;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/22/2021 6:15 PM
 */
public class MaxArea1 {
    public static void main(String[] args) {
        MaxArea1 ma = new MaxArea1();
        int[][] arr = {
                {1, 0, 1, 1, 0},
                {1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1}
        };
        System.out.println(ma.getMaxArea(arr));
    }

    public int getMaxArea(int[][] nums) {

        int rows = nums.length;
        int max = 0;
        for (int i = 0; i < rows; ++i) {
            int columns = nums[i].length;
            for (int j = 0; j < columns; ++j) {
                int cur;
                if (nums[i][j] == 1) {
                    if ((cur = getNum(nums, i, j)) > max) {
                        max = cur;
                    }
                }
            }
        }
        return max;
    }

    private int getNum(int[][] nums, int i, int j) {


        //set zero
        nums[i][j] = 0;
        int num = 1;
        int ni, nj;

        // UP
        ni = i - 1;
        nj = j;
        if (ni > 0 && nj < nums[ni].length && nums[ni][nj] == 1) {
            num += getNum(nums, ni, nj);
        }

        // DOWN
        ni = i + 1;
        nj = j;
        if (ni < nums.length && nj < nums[ni].length && nums[ni][nj] == 1) {
            num += getNum(nums, ni, nj);
        }

        // LEFT
        ni = i;
        nj = j - 1;
        if (nj > 0 && nums[ni][nj] == 1) {
            num += getNum(nums, ni, nj);
        }

        //RIGHT
        ni = i;
        nj = j + 1;
        if (nj < nums[ni].length && nums[ni][nj] == 1) {
            num += getNum(nums, ni, nj);
        }
        return num;
    }
}
