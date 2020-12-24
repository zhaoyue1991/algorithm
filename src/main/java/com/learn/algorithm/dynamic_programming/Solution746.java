package com.learn.algorithm.dynamic_programming;

/**
 * @author zhaoyue23
 * @create 2020/12/23
 * @since 1.0.0
 */
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if (null == cost || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = Math.min(first + cost[i], second + cost[i]);
            first = second;
            second = temp;
        }
        return Math.min(first, second);
    }

    public static void main(String[] args) {
        System.out.println(new Solution746().minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(new Solution746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }
}
