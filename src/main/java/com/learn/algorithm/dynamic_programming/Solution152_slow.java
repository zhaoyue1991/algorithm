package com.learn.algorithm.dynamic_programming;

/**
 * @author zhaoyue23
 * @create 2020/12/25
 * @since 1.0.0
 */
public class Solution152_slow {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int dp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                temp = temp * nums[j];
                dp = Math.max(temp, dp);
            }
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution152_slow().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Solution152_slow().maxProduct(new int[]{-2, 0, -1}));
        System.out.println(new Solution152_slow().maxProduct(new int[]{0, 2}));

    }

}
