package com.learn.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyue23
 * @create 2021/3/13
 * @since 1.0.0
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                order.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                order.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    order.add(matrix[bottom][i]);
                }
                for (int i = bottom -1 ; i > top; i--) {
                    order.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new Solution54().spiralOrder(matrix));
        System.out.println(new Solution54().spiralOrder(new int[][]{{2, 5}, {8, 4}, {0, -1}}));

    }
}
