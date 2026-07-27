# 26. Remove Duplicates from Sorted Array

**Difficulty:** Easy  
**Topics:** Array, Two Pointers  
**LeetCode:** [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

---

## Problem Statement

Given an integer array `nums` sorted in **non-decreasing** order, remove the duplicates **in-place** such that each unique element appears only once. The relative order of the elements should be kept the same.

Return the number of unique elements `k`.  
The first `k` elements of `nums` should contain the unique elements.

### Examples
```
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
```

### Constraints
- `1 <= nums.length <= 3 * 10⁴`
- `-100 <= nums[i] <= 100`
- `nums` is sorted in non-decreasing order.

---

## Approach: Two Pointers

### Idea
Because the array is sorted, duplicates are adjacent.  
Use a slow pointer (`k`) that tracks the position of the next unique element.  
Fast pointer scans the array. Whenever a new value is found, write it at position `k` and increment `k`.

### Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## Key Takeaways
- Classic in-place two-pointer technique for sorted arrays.
- The slow pointer always points to the place where the next unique value should be written.
- Same pattern appears in “Remove Element”, “Move Zeroes”, etc.
