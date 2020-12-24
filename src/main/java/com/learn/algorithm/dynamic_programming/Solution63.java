package com.learn.algorithm.dynamic_programming;

/**
 * @author zhaoyue23
 * @create 2020/12/24
 * @since 1.0.0
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new Solution63().uniquePathsWithObstacles(obstacleGrid));
        int[][] obstacleGrid1 = new int[][]{{0, 1}, {0, 0}};
        System.out.println(new Solution63().uniquePathsWithObstacles(obstacleGrid1));
        int[][] obstacleGrid2 = new int[][]{{1, 0}};
        System.out.println(new Solution63().uniquePathsWithObstacles(obstacleGrid2));
    }
}
