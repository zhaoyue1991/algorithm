package com.learn.algorithm.dynamic_programming;

/**
 * @author zhaoyue23
 * @create 2020/12/18
 * @since 1.0.0
 */
public class Solution53 {

    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int i : nums) {
            pre = Math.max(pre + i, i);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1};
        System.out.println(maxSubArray(nums));
    }

}
