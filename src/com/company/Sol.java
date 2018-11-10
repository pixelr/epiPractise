package com.company;

public class Sol {

    public static boolean hasCycle(ListNode head) {

        while (head != null) {
            if (head.next == head) return true;
            ListNode oldHead = head;
            head = head.next;
            oldHead.next = oldHead;
        }
        return false;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(Sol.hasCycle(head));
    }
}
