# 21. Merge Two Sorted Lists

**Difficulty:** Easy  
**Topics:** Linked List, Recursion  
**LeetCode:** [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

---

## Problem Statement

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

### Examples
```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Input: list1 = [], list2 = []
Output: []

Input: list1 = [], list2 = [0]
Output: [0]
```

### Constraints
- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 <= Node.val <= 100`
- Both `list1` and `list2` are sorted in **non-decreasing** order.

---

## Approach 1: Iterative with Dummy Node (Recommended)

### Idea
- Create a dummy node to avoid edge-case handling for the head.
- Use a `tail` pointer. Always attach the smaller of the two current nodes.
- When one list is exhausted, attach the remaining part of the other list.

### Complexity
- **Time:** O(n + m)
- **Space:** O(1) extra (only pointers)

---

## Approach 2: Recursive

```java
if (list1 == null) return list2;
if (list2 == null) return list1;
if (list1.val < list2.val) {
    list1.next = merge(list1.next, list2);
    return list1;
} else {
    list2.next = merge(list1, list2.next);
    return list2;
}
```

Elegant but uses O(n + m) stack space.

---

## Key Takeaways
- Dummy node is a powerful technique for linked-list problems.
- Always consider the case when one (or both) lists are empty.
- This is the foundation for merge-sort on linked lists and for “merge k sorted lists”.
