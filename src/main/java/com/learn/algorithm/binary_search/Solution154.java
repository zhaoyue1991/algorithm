package com.learn.algorithm.binary_search;

/**
 * @author zhaoyue23
 * @create 2021/3/19
 * @since 1.0.0
 */
public class Solution154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Solution154().findMin(new int[]{2, 2, 2, 0, 1}));
    }
}
