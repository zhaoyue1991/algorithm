package com.learn.data_structure.singleLinkedList;

public class SingleILinkedList<T> implements ILinkedList<T> {

  protected Node<T> head; //带数据头结点

  public SingleILinkedList(Node<T> head) {
    this.head = head;
  }

  @Override
  public boolean isEmpty() {
    return this.head == null;
  }

  @Override
  public int length() {
    int length = 0;
    Node<T> p = this.head;
    while (p != null) {
      length++;
      p = p.next;
    }
    return length;
  }

  @Override
  public T get(int index) {
    if (this.head != null && index > 0) {
      int count = 0;
      Node<T> p = this.head;
      while (p != null && count < index) {
        count++;
        p = p.next;
      }
      if (p != null) {
        return p.data;
      }
    }
    return null;
  }

  @Override
  public T set(int index, T data) {
    if (this.head != null && index > 0) {
      int count = 0;
      Node<T> p = this.head;
      while (p != null && count < index) {
        count++;
        p = p.next;
      }
      if (p != null) {
        T oldData = p.data;
        p.data = data;
        return oldData;
      }
    }
    return null;
  }

  @Override
  public boolean add(int index, T data) {
    if (data == null) {
      return false;
    }
    if (this.head == null || index <= 1) {
      this.head = new Node<T>(data, this.head);
    } else {
      int count = 0;
      Node<T> front = this.head;
      while (front.next != null && count < index - 1) {
        front = front.next;
        count++;
      }
      front.next = new Node<>(data, front.next);
    }
    return true;
  }

  @Override
  public boolean add(T data) {
    return false;
  }

  @Override
  public T remove(int index) {
    T old = null;
    if (this.head != null && index >= 0) {
      if (index == 0) {
        old = this.head.data;
        this.head = this.head.next;
        return old;
      } else {
        int count = 0;
        Node<T> front = this.head;
        while (front.next != null && count < index - 1) {
          count++;
          front = front.next;
        }
        //要删除节点
        Node<T> r = front.next;
        if (r != null) {
          old = r.data;
          front.next = r.next;
          r = null;
        }
      }
    }
    return old;
  }

  @Override
  public boolean removeAll(T data) {
    return false;
  }

  @Override
  public void clear() {
    this.head = null;
  }

  @Override
  public boolean contains(T data) {
    return false;
  }
}
