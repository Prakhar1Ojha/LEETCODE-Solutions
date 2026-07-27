/**
 * LeetCode 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a sorted list.
 *
 * Time:  O(n + m)
 * Space: O(1) iterative / O(n + m) recursive
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    // Iterative approach with dummy node (preferred)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining part
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    // Recursive approach
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    // Helper to print a list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // list1: 1 -> 2 -> 4
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // list2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode merged = sol.mergeTwoLists(l1, l2);
        printList(merged); // 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }
}