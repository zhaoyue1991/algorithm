package com.learn.algorithm.dynamic_programming;

/**
 * @author zhaoyue23
 * @create 2020/12/18
 * @since 1.0.0
 */
public class Solution70 {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int p = 1;
        int q = 2;
        int r = 0;
        for (int i = 3; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;

        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
