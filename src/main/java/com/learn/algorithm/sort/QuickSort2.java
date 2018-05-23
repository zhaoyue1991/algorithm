package com.learn.algorithm.sort;

import java.util.Arrays;

public class QuickSort2 {

  static void quickSort(int a[], int low, int high) {
    if (low < high) {
      int pivot = partition(a, low, high);
      quickSort(a, low, pivot - 1);
      quickSort(a, pivot + 1, high);
    }
  }

  static int partition(int a[], int low, int high) {
    int pivotValue = a[low];
    while (low < high) {
      while (low < high && a[high] >= pivotValue) {
        high--;
      }
      swap(a, low, high);
      while (low < high && a[low] <= pivotValue) {
        low++;
      }
      swap(a, low, high);
    }
    return low;
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
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

