package com.learn.algorithm.dynamic_programming;

/**
 * @author zhaoyue23
 * @create 2020/12/25
 * @since 1.0.0
 */
public class Solution152_fast {

    public int maxProduct(int[] nums) {
        int maxF = nums[0];
        int minF = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = maxF;
            int mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            minF = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
            max = Math.max(maxF, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution152_fast().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Solution152_fast().maxProduct(new int[]{-2, 0, -1}));
        System.out.println(new Solution152_fast().maxProduct(new int[]{0, 2}));

    }

}
