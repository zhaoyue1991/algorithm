package com.learn.algorithm.dynamic_programming;

/**
 * @author zhaoyue23
 * @create 2020/12/21
 * @since 1.0.0
 */
public class Solution198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(first + nums[i], second);
            first = second;
            second = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new Solution198().rob(new int[]{2, 1, 1, 2}));
    }
}
