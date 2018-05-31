package com.learn.data_structure.singleLinkedList;

/**
 * 节点
 */
public class Node<T> {

  public T data;
  public Node<T> next;

  public Node(T data) {
    this.data = data;
  }

  public Node(T data, Node<T> next) {
    this.data = data;
    this.next = next;
  }
}
