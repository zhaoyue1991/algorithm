package com.learn.algorithm.greedy;

public class Solution122 {
  public int maxProfit(int[] prices) {
    int reslut = 0;
    if (null == prices || prices.length == 0) {
      return 0;
    }
    for (int i = 1; i < prices.length; i++) {
      if (prices[i - 1] < prices[i]) {
        reslut += prices[i] - prices[i - 1];
      }
    }
    return reslut;
  }

  public static void main(String[] args) {
    int[] a = new int[]{7, 1, 5, 3, 6, 4};
    int[] b = new int[]{1, 2, 3, 4, 5};
    int[] c = new int[]{7, 6, 4, 3, 1};

    System.out.println(new Solution122().maxProfit(a));
    System.out.println(new Solution122().maxProfit(b));
    System.out.println(new Solution122().maxProfit(c));
  }
}
