package com.learn.data_structure.singleLinkedList;

import java.util.HashSet;
import java.util.Set;

public class Solution83 {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode deleteDuplicates(ListNode head) {
    Set<Integer> set = new HashSet<>();
    if (head == null || head.next == null) {
      return head;
    }
    ListNode front = head;
    set.add(head.val);
    ListNode temp = head.next;
    while (temp != null) {
      if (set.contains(temp.val)) {
        front.next = temp.next;
        temp = temp.next;
      } else {
        set.add(temp.val);
        front = front.next;
        temp = temp.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(3);
    head.next = a;
    a.next = b;
    b.next = c;
    c.next = d;
    ListNode result = deleteDuplicates(head);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
