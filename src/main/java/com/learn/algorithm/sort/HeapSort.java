package com.learn.algorithm.sort;

import java.util.Arrays;

public class HeapSort {

  /**
   * 父节点
   */
  private static int parent(int i) {
    return (i - 1) / 2;
  }

  /**
   * 左节点
   */
  private static int left(int i) {
    return i * 2 + 1;
  }

  /**
   * 右节点
   */
  private static int right(int i) {
    return i * 2 + 2;
  }

  /**
   * 最大堆算法
   *
   * @param a    原数组
   * @param i    起始节点
   * @param size 最大长度
   */
  private static void maxHeapify(int[] a, int i, int size) {
    int l = left(i);
    int r = right(i);
    int largest = i;
    if (l < size && a[l] > a[i]) {
      largest = l;
    }
    if (r < size && a[r] > a[largest]) {
      largest = r;
    }
    if (largest != i) {
      swap(a, i, largest);
      maxHeapify(a, largest, size);
    }
  }

  /**
   * 交换方法
   */
  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  /**
   * 建立最大堆
   */
  private static void buildMaxHeap(int[] arr, int size) {
    for (int i = size / 2 - 1; i >= 0; --i)
      maxHeapify(arr, i, size);
  }

  /**
   * 排序
   *
   * @param arr 原数组
   */
  private static void heapSort(int[] arr) {
    int length = arr.length;
    buildMaxHeap(arr, length);
    for (int i = length - 1; i >= 1; i--) {
      swap(arr, 0, i);
      length--;
      maxHeapify(arr, 0, length);
    }
  }

  /**
   * 最大优先队列-返回最大值
   */
  public static int heapMaximum(int[] arr) {
    return arr[0];
  }

  /**
   * 最大优先队列-去除最大值
   */
  public static int heapExtractMax(int[] arr) throws Exception {
    if (arr.length < 1) {
      throw new Exception("");
    }
    int max = arr[0];
    arr[0] = arr[arr.length - 1];
    maxHeapify(arr, 0, arr.length - 1);
    return max;
  }

  /**
   * 最大优先队列-元素i的key值增加到k之后
   */
  public static void heapIncreaseKey(int[] arr, int i, int k) throws Exception {
    if (k < arr[i]) {
      throw new Exception("new key is smaller than current key");
    }
    arr[i] = k;
    while (i > 0 && arr[parent(i)] < arr[i]) {
      swap(arr, parent(i), i);
      i = parent(i);
    }
  }

  public static int[] maxHeapInsert(int[] arr, int i) throws Exception {
    int[] temp = new int[arr.length + 1];
    System.arraycopy(arr, 0, temp, 0, arr.length);
    temp[arr.length] = Integer.MIN_VALUE;
    heapIncreaseKey(temp, temp.length - 1, i);
    return temp;
  }


  public static void main(String[] args) throws Exception {
    int[] a = {5, 2, 4, 6, 1, 3, 2, 6, 10};
    System.out.println("==========a=============");
    maxHeapify(a, 0, a.length);
    System.out.println(Arrays.toString(a));

    buildMaxHeap(a, a.length);
    System.out.println(Arrays.toString(a));

    heapSort(a);
    System.out.println(Arrays.toString(a));

    int[] a1 = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
    System.out.println("==========a1=============");
    maxHeapify(a1, 0, a1.length);
    System.out.println(Arrays.toString(a1));

    buildMaxHeap(a1, a1.length);
    System.out.println(Arrays.toString(a1));

    heapSort(a1);
    System.out.println(Arrays.toString(a1));

    System.out.println(Arrays.toString(maxHeapInsert(a1, 20)));

  }
}
