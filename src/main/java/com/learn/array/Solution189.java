package com.learn.array;

/**
 * @author zhaoyue23
 * @create 2021/1/8
 * @since 1.0.0
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public void rotateSlow(int[] nums, int k) {
        int time = k % nums.length;
        for (int i = 1; i <= time; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = last;
        }
    }
}
