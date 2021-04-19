package com.xpcf.algorithm.leetcode.dp;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/19/2021 8:51 PM
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        int len = prices.length;
        for (int i = 0; i < len; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }


}
