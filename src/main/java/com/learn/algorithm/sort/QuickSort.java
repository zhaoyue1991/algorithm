package com.learn.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

  /**
   * @param a 原数组
   * @param p 开始下标
   * @param r 结束下标
   */
  private static void quickSort(int[] a, int p, int r) {
    if (p < r) {
      int q = partition(a, p, r);
      quickSort(a, p, q - 1);
      quickSort(a, q + 1, r);
    }
  }

  /**
   * @param a 原始数组
   * @param p 开始下标
   * @param r 结束下标
   */
  private static int partition(int[] a, int p, int r) {
    int x = a[r];
    int i = p - 1;
    for (int j = p; j < r; j++) {
      if (a[j] < x) {
        i = i + 1;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
    }
    a[r] = a[i + 1];
    a[i + 1] = x;
    return i + 1;
  }

  public static void main(String[] args) {
    int[] a = {2, 8, 7, 1, 3, 5, 6, 4};
    quickSort(a, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
    int[] a1 = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
    quickSort(a1, 0, a1.length - 1);
    System.out.println(Arrays.toString(a1));
  }
}
