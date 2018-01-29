package com.learn.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

  /**
   * @param a 原数组
   * @param s 第一个有序起始下标
   * @param m 第二个有序起始下标
   * @param t 第二个有序结束下标
   */
  private static void merge(int[] a, int s, int m, int t) {
    int[] temp = new int[t - s + 1];
    int i = s;
    int j = m;
    int k = 0;
    while (i < m && j <= t) {
      if (a[i] <= a[j]) {
        temp[k] = a[i];
        k++;
        i++;
      } else {
        temp[k] = a[j];
        k++;
        j++;
      }
    }
    while (i < m) {
      temp[k] = a[i];
      k++;
      i++;
    }
    while (j <= t) {
      temp[k] = a[j];
      k++;
      j++;
    }
    System.arraycopy(temp, 0, a, s, temp.length);
  }

  /**
   * @param a     原数组
   * @param start 开始下标
   * @param end   结束下标
   */
  private static void mergeSort(int[] a, int start, int end) {
    int mid;
    if (start < end) {
      mid = (start + end) / 2;
      mergeSort(a, start, mid);
      mergeSort(a, mid + 1, end);
      merge(a, start, mid + 1, end);
    }
  }

  public static void main(String[] args) {
    int[] a = {50, 10, 20, 30, 70, 40, 80, 60};
    mergeSort(a, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
  }
}
