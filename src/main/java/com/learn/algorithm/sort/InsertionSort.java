package com.learn.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

  private static int[] sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0; j--) {
        if (arr[j - 1] > arr[j]) {
          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
        } else {
          break;
        }
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = {5, 2, 4, 6, 1, 3};
    int[] arr1 = {31, 41, 59, 26, 41, 58};
    System.out.println(Arrays.toString(sort(arr)));
    System.out.println(Arrays.toString(sort(arr1)));
  }
}
