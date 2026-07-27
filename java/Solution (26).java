# 27. Remove Element

**Difficulty:** Easy  
**Topics:** Array, Two Pointers  
**LeetCode:** [Remove Element](https://leetcode.com/problems/remove-element/)

---

## Problem Statement

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in-place.  
The order of the elements may be changed.  
Return the number of elements that are not equal to `val`.

### Examples
```
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
```

### Constraints
- `0 <= nums.length <= 100`
- `0 <= nums[i] <= 50`
- `0 <= val <= 100`

---

## Approach: Two Pointers

### Idea
Use a slow pointer `k` that indicates the next position to keep.  
Fast pointer scans every element. If the element is **not** equal to `val`, copy it to position `k` and increment `k`.

### Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## Alternative (when order doesn’t matter)
Swap the element to remove with the last element and shrink the array size.  
Can reduce writes when many elements need to be removed.

---

## Key Takeaways
- Almost identical pattern to “Remove Duplicates”.
- Two-pointer technique is extremely common for in-place array modifications.
