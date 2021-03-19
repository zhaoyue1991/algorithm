package com.learn.algorithm.binary_search;

/**
 * @author zhaoyue23
 * @create 2021/3/18
 * @since 1.0.0
 */
public class Solution153 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Solution153().findMin(new int[]{4, 5, 6, 1, 2, 3}));
        System.out.println(new Solution153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new Solution153().findMin(new int[]{11, 13, 15, 17}));
        System.out.println(new Solution153().findMin(new int[]{3, 4, 5, 1, 2}));

    }
}
