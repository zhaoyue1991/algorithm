package com.learn.algorithm.binary_tree;

public class BinarySearchTree<T extends Comparable> implements Tree<T> {

  private BinaryNode<T> root;

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public int height() {
    return 0;
  }

  @Override
  public String preOrder() {
    return null;
  }

  @Override
  public String inOrder() {
    return null;
  }

  @Override
  public String postOrder() {
    return null;
  }

  @Override
  public String levelOrder() {
    return null;
  }

  @Override
  public void insert(T data) {
    if (data == null)
      throw new RuntimeException("data can\'Comparable be null !");
    this.insert(this.root, data);
  }

  private void insert(BinaryNode<T> p, T data) {
    if (p == null) {
      p = new BinaryNode<>(data, null, null);
    }
    int compareResult = data.compareTo(p.data);
    if (compareResult < 0) {
      insert(p.left, data);
    } else if (compareResult > 0) {
      insert(p.right, data);
    }
  }

  @Override
  public void remove(T data) {
    if (data == null)
      throw new RuntimeException("data can\'Comparable be null !");
    this.remove(data, this.root);
  }

  private void remove(T data, BinaryNode<T> p) {

  }

  @Override
  public T findMin() {
    return null;
  }

  @Override
  public T findMax() {
    return null;
  }

  @Override
  public BinaryNode findNode(T data) {
    return null;
  }

  @Override
  public boolean contains(T data) throws Exception {
    return false;
  }

  @Override
  public void clear() {

  }

  public static void main(String[] args) {
    System.out.println("84c6ad17f47fadfb53c15a2d51cc2aa8d2b97cc8efd8d31ad9eda6d2fba49a68".length());
  }
}
