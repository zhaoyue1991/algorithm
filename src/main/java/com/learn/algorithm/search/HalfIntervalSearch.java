package com.learn.algorithm.search;

public class HalfIntervalSearch {

  public static int search(int[] a, int start, int end, int key) {
    int mid = (end - start) / 2 + start;
    if (a[mid] == key) {
      return mid;
    }
    if (start >= end) {
      return -1;
    } else if (a[mid] < key) {
      return search(a, mid + 1, end, key);
    } else if (a[mid] > key) {
      return search(a, start, mid - 1, key);
    }
    return -1;
  }

  public static void main(String[] args) {
    int a[] = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
    System.out.println(search(a, 0, a.length - 1, 30));
    System.out.println(search(a, 0, a.length - 1, 3));
    System.out.println(search(a, 0, a.length - 1, 78));
    System.out.println(search(a, 0, a.length - 1, 13));
  }
}
