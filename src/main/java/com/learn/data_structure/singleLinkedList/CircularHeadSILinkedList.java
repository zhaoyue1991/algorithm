package com.learn.data_structure.singleLinkedList;

public class CircularHeadSILinkedList<T> implements ILinkedList<T> {

  protected Node<T> head; //不带数据头结点
  protected Node<T> tail;//指向尾部的指针

  public CircularHeadSILinkedList() {
    this.head = new Node<T>(null);
    this.head.next = head;
    this.tail = head;
  }

  public CircularHeadSILinkedList(T[] array) {
    this();
    if (array != null && array.length > 0) {
      this.head.next = new Node<>(array[0], head);
      tail = this.head.next;
      int i = 1;
      while (i < array.length) {
        tail.next = new Node<>(array[i++]);
        tail.next.next = head;
        tail = tail.next;
      }
    }
  }

  @Override
  public boolean isEmpty() {
    return this.head.next == head;
  }

  @Override
  public int length() {
    int length = 0;
    Node<T> p = this.head.next;
    while (p != head) {
      p = p.next;
      length++;
    }
    return length;
  }

  @Override
  public T get(int index) {
    if (index >= 0) {
      Node<T> temp = this.head.next;
      int i = 0;
      while (temp != head && i < index) {
        temp = temp.next;
        i++;
      }
      if (temp != null) {
        return temp.data;
      }
    }
    return null;
  }

  @Override
  public T set(int index, T data) {
    if (data == null) {
      return null;
    }
    if (index >= 0) {
      int j = 0;
      Node<T> p = this.head.next;
      while (p != head && j < index) {
        j++;
        p = p.next;
      }
      //如果不是头结点
      if (p != head) {
        T old = p.data;
        p.data = data;
        return old;
      }
    }
    return null;
  }

  @Override
  public boolean add(int index, T data) {
    int size = length();
    if (data == null || index < 0 || index >= size)
      return false;

    int i = 0;
    Node<T> front = this.head;
    while (i < index && front.next != null) {
      i++;
      front = front.next;
    }
    Node<T> temp = new Node<>(data, front.next);
    front.next = temp;
    if (front == tail) {
      tail = temp;
    }
    return true;
  }

  @Override
  public boolean add(T data) {
    if (data != null) {
      Node<T> temp = new Node<T>(data, this.tail.next);
      this.tail.next = temp;
      this.tail = temp;
      return true;
    }
    return false;
  }

  @Override
  public T remove(int index) {
    int size = length();
    if (index < 0 || index >= size || isEmpty()) {
      return null;
    }
    int i = 0;
    Node<T> front = this.head;
    while (front.next != this.head && i < index) {
      front = front.next;
      i++;
    }
    if (front != head) {
      T old = front.next.data;
      if (tail == front.next) {
        tail = front;
      }
      front.next = front.next.next;
      return old;
    }

    return null;
  }

  @Override
  public boolean removeAll(T data) {
    if (data == null) {
      return false;
    }
    boolean isRemove = false;
    //用于记录要删除结点的前一个结点
    Node<T> front = this.head;
    //当前遍历的结点
    Node<T> temp = front.next;
    //查找所有数据相同的结点并删除
    while (temp != head) {
      if (data.equals(temp.data)) {
        //如果恰好是尾部结点,则更新tail的指向
        if (data.equals(tail.data)) {
          this.tail = front;
        }
        //相等则删除pre并更改指针指向
        front.next = temp.next;
        temp = front.next;
        isRemove = true;
      } else {
        front = temp;
        temp = temp.next;
      }
    }
    return isRemove;
  }

  @Override
  public void clear() {
    this.head.next = head;
    this.tail = head;
  }

  @Override
  public boolean contains(T data) {
    if (data == null) {
      return false;
    }
    Node<T> temp = this.head.next;
    while (temp != this.head) {
      if (temp.data.equals(data)) {
        return true;
      }
      temp = temp.next;
    }
    return false;
  }

  @Override
  public String toString() {
    String str = "(";
    Node<T> p = this.head.next;
    while (p != head) {
      str += p.data.toString();
      p = p.next;
      if (p != head)
        str += ", ";
    }
    return str + ")";
  }

  public static void main(String[] args) {

    String[] letters = {"A", "B", "C", "D", "E", "F"};
    CircularHeadSILinkedList<String> list = new CircularHeadSILinkedList<>(letters);

    System.out.println("list.get(3)->" + list.get(3));
    System.out.println("list:" + list.toString());

    System.out.println("list.add(4,Y)—>" + list.add(4, "Y"));
    System.out.println("list:" + list.toString());
    System.out.println("list.add(Z)—>" + list.add("Z"));
    System.out.println("list:" + list.toString());


    System.out.println("list.contains(Z)->" + list.contains("Z"));
    System.out.println("list.set(4,P)-->" + list.set(4, "P"));
    System.out.println("list:" + list.toString());

    System.out.println("list.removeAll(Z)->" + list.removeAll("Z"));
    System.out.println("list.remove(4)-->" + list.remove(4));
    System.out.println("list:" + list.toString());
  }
}
