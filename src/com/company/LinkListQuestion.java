package com.company;

public class LinkListQuestion {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val,ListNode next) {this. val = val;this.next=next; }

        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            int size = 0;
            ListNode current = head;
            while (current != null) {
                size++;
                current = current.next;
            }
            int indexToRemove = size - n;
            ListNode prev = head;
            int i = 1;
            while (i < indexToRemove ) {
                prev = prev.next;
                i++;
            }
            prev.next = prev.next.next;
            return head;
        }
    }

}
