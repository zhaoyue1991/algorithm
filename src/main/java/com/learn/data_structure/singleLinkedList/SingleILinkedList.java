package com.learn.data_structure.singleLinkedList;

/**
 * 单项链表的实现,不含独立头结点,不含尾部指针
 */
public class SingleILinkedList<T> implements ILinkedList<T> {

  protected Node<T> head; //带数据头结点

  public SingleILinkedList(Node<T> head) {
    this.head = head;
  }

  public SingleILinkedList(T[] array) {
    if (array != null && array.length > 0) {
      this.head = new Node<T>(array[0]);
      Node<T> temp = this.head;
      int i = 1;
      while (i < array.length) {
        temp.next = new Node<T>(array[i]);
        temp = temp.next;
        i++;
      }
    }
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
    if (this.head != null) {
      Node<T> temp = this.head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = new Node<>(data);
      return true;
    }
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
    boolean isRemove = false;
    if (this.head != null && data != null) {
      if (data.equals(this.head.data)) {
        this.head = this.head.next;
        isRemove = true;
      }
      Node<T> front = this.head;
      Node<T> temp = this.head.next;
      while (temp != null) {
        if (data.equals(temp.data)) {
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
    this.head = null;
  }

  @Override
  public boolean contains(T data) {
    if (data != null) {
      Node<T> temp = this.head;
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
    Node<T> pre = this.head;
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
    SingleILinkedList<String> list = new SingleILinkedList<>(letters);

    System.out.println("list.get(3)->" + list.get(3));
    System.out.println("list:" + list.toString());

    System.out.println("list.add(4,Y)—>" + list.add(4, "Y"));
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
