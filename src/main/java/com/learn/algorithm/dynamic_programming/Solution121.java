package com.learn.algorithm.dynamic_programming;

public class Solution121 {
  public int maxProfit(int[] prices) {
    int reslut = 0;
    if (null == prices || prices.length == 0) {
      return 0;
    }
    int minPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      reslut = Math.max(reslut, prices[i] - minPrice);
      minPrice = Math.min(minPrice, prices[i]);
    }
    return reslut;
  }

  public static void main(String[] args) {
    int[] a = new int[]{7, 6, 4, 3, 1};
    int[] b = new int[]{7, 1, 5, 3, 6, 4};
    System.out.println(new Solution121().maxProfit(b));
    System.out.println(new Solution121().maxProfit(a));
  }
}
