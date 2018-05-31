package com.learn.data_structure.singleLinkedList;

public class HeadSingleILinkedList<T> implements ILinkedList<T> {

  protected Node<T> headNode; //不带数据头结点
  protected Node<T> rear;//指向尾部的指针

  public HeadSingleILinkedList() {
    //初始化头结点与尾指针
    this.headNode = rear = new Node<>(null);
  }

  public HeadSingleILinkedList(Node<T> head) {
    this();
    this.headNode.next = rear.next = head;
    rear = rear.next;//更新末尾指针指向
  }

  /**
   * 传入一个数组,转换成链表
   */
  public HeadSingleILinkedList(T[] array) {
    this();
    if (array != null && array.length > 0) {
      this.headNode.next = new Node<T>(array[0]);
      rear = this.headNode.next;
      int i = 1;
      while (i < array.length) {
        rear.next = new Node<T>(array[i++]);
        rear = rear.next;
      }
    }
  }

  @Override
  public boolean isEmpty() {
    return this.headNode.next == null;
  }

  @Override
  public int length() {
    int length = 0;
    Node<T> temp = this.headNode.next;
    while (temp != null) {
      length++;
      temp = temp.next;
    }
    return length;
  }

  @Override
  public T get(int index) {
    if (index >= 0) {
      int i = 0;
      Node<T> temp = this.headNode.next;
      while (temp != null && i < index) {
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
    if (index >= 0 && data != null) {
      Node<T> temp = this.headNode.next;
      int i = 0;
      while (temp != null && i < index) {
        temp = temp.next;
        i++;
      }
      if (temp != null) {
        T oldData = temp.data;
        temp.data = data;//设置新值
        return oldData;
      }
    }
    return null;
  }

  @Override
  public boolean add(int index, T data) {
    if (data == null) {
      throw new NullPointerException("data can\'t be empty!");
    }
    if (index < 0)
      throw new NullPointerException("index can\'t less than 0");
    int count = 0;
    Node<T> front = this.headNode;
    while (front.next != null && count < index) {
      front = front.next;
      count++;
    }
    Node<T> newNode = new Node<>(data, front.next);
    front.next = newNode;
    if (front == rear) {
      this.rear = newNode;
    }
    return true;
  }

  @Override
  public boolean add(T data) {
    if (data == null)
      throw new NullPointerException("data can\'t be empty!");
    this.rear.next = new Node<>(data);
    this.rear = this.rear.next;
    return true;
  }

  @Override
  public T remove(int index) {
    T old = null;
    if (index >= 0) {
      int i = 0;
      Node<T> front = this.headNode;
      while (i < index && front.next != null) {
        front = front.next;
        i++;
      }
      Node<T> r = front.next;
      if (r != null) {
        old = r.data;
        if (r == this.rear) {
          this.rear = front;
        }
        front.next = r.next;
      }
    }
    return old;
  }

  @Override
  public boolean removeAll(T data) {
    boolean isRemove = false;
    if (data != null) {
      Node<T> front = this.headNode;
      Node<T> temp = this.headNode.next;
      while (temp != null) {
        if (data == temp.data) {
          if (data.equals(rear.data)) {
            this.rear = front;
          }
          front.next = temp.next;
          temp = temp.next;
          isRemove = true;
        } else {
          front = front.next;
          temp = temp.next;
        }
      }
    }
    return isRemove;
  }

  @Override
  public void clear() {
    this.headNode.next = null;
    this.rear = null;
  }

  @Override
  public boolean contains(T data) {
    if (data != null) {
      Node<T> temp = this.headNode;
      while (temp != null) {
        if (temp.data == data) {
          return true;
        }
        temp = temp.next;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    String str = "(";
    Node<T> pre = this.headNode.next;
    while (pre != null) {
      str += pre.data;
      pre = pre.next;
      if (pre != null)
        str += ", ";
    }
    return str + ")";
  }

  public static void main(String[] args) {

    String[] letters = {"A", "B", "C", "D", "E", "F"};
    HeadSingleILinkedList<String> list = new HeadSingleILinkedList<>(letters);

    System.out.println("list.get(3)->" + list.get(3));
    System.out.println("list:" + list.toString());

    System.out.println("list.add(4,Y)—>" + list.add(4, "Y"));
    System.out.println("list:" + list.toString());
    System.out.println("list.add(Z)—>" + list.add("Z"));
    System.out.println("list:" + list.toString());


    System.out.println("list.contains(Z)->" + list.contains("Z"));
    System.out.println("list.set(4,P)-->" + list.set(4, "P"));
    System.out.println("list:" + list.toString());

    System.out.println("list.remove(Z)->" + list.removeAll("Z"));
    System.out.println("list.remove(4)-->" + list.remove(4));
    System.out.println("list:" + list.toString());
  }
}
