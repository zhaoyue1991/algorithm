package com.learn.algorithm.dynamic_programming;

/**
 * @author zhaoyue23
 * @create 2021/1/11
 * @since 1.0.0
 */
public class Solution122 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // 持有现金
        dp[0][0] = 0;
        // 持有股票
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 1, 5, 3, 6, 4};
        int[] b = new int[]{1, 2, 3, 4, 5};
        int[] c = new int[]{7, 6, 4, 3, 1};

        System.out.println(new com.learn.algorithm.greedy.Solution122().maxProfit(a));
        System.out.println(new com.learn.algorithm.greedy.Solution122().maxProfit(b));
        System.out.println(new com.learn.algorithm.greedy.Solution122().maxProfit(c));
    }
}
