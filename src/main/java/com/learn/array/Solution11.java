package com.learn.array;

/**
 * @author zhaoyue23
 * @create 2021/1/14
 * @since 1.0.0
 */
public class Solution11 {

    public int maxArea(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(new Solution11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new Solution11().maxArea(new int[]{1, 1}));
        System.out.println(new Solution11().maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(new Solution11().maxArea(new int[]{1, 2, 1}));

    }
}
