package com.learn.algorithm.binary_tree;

public interface Tree<T extends Comparable> {
  /**
   * 判空
   */
  boolean isEmpty();

  /**
   * 二叉树的结点个数
   */
  int size();

  /**
   * 返回二叉树的高度或者深度,即结点的最大层次
   */
  int height();

  /**
   * 先根次序遍历
   */
  String preOrder();

  /**
   * 中根次序遍历
   */
  String inOrder();

  /**
   * 后根次序遍历
   */
  String postOrder();

  /**
   * 层次遍历
   */
  String levelOrder();

  /**
   * 将data 插入
   */
  void insert(T data);

  /**
   * 删除
   */
  void remove(T data);

  /**
   * 查找最大值
   */
  T findMin();

  /**
   * 查找最小值
   */
  T findMax();

  /**
   * 根据值找到结点
   */
  BinaryNode findNode(T data);

  /**
   * 是否包含某个值
   */
  boolean contains(T data) throws Exception;

  /**
   * 清空
   */
  void clear();
}
