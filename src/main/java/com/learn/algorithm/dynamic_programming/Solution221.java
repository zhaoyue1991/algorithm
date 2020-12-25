package com.learn.algorithm.dynamic_programming;


/**
 * @author zhaoyue23
 * @create 2020/12/25
 * @since 1.0.0
 */
public class Solution221 {

    public int maximalSquare(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
