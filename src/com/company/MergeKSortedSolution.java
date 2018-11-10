package com.company;

import java.util.PriorityQueue;

public class MergeKSortedSolution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class ListEntry {
        public int pos;
        public int val;

        public ListEntry(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListEntry> priorityQueue
                = new PriorityQueue<>(lists.length, (a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                priorityQueue.add(new ListEntry(i, lists[i].val));
                lists[i] = lists[i].next;
            }
        }

        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while (!priorityQueue.isEmpty()) {
            ListEntry le = priorityQueue.poll();
            head.next = new ListNode(le.val);
            head = head.next;
            if (lists[le.pos] != null) {
                priorityQueue.add(new ListEntry(le.pos, lists[le.pos].val));
                lists[le.pos] = lists[le.pos].next;
            }
        }
        head.next = null;
        return dummy.next;
    }

    public ListNode makeListNode(int[] val) {
        ListNode dummy = new ListNode(-1);
        ListNode ret = dummy;
        for (int i : val) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }
        dummy.next = null;
        return ret.next;
    }

    public static void main(String[] args) {
        MergeKSortedSolution mergeKSortedSolution = new MergeKSortedSolution();
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = mergeKSortedSolution.makeListNode(new int[]{1, 4, 5});
        listNodes[1] = mergeKSortedSolution.makeListNode(new int[]{1, 3, 4});
        listNodes[2] = mergeKSortedSolution.makeListNode(new int[]{2, 6});

        ListNode out = mergeKSortedSolution.mergeKLists(listNodes);
        while (out != null) {
            System.out.print(out.val + ", ");
            out = out.next;
        }
    }
}
