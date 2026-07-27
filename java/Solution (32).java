# 977. Squares of a Sorted Array

**Difficulty:** Easy  
**Topics:** Array, Two Pointers, Sorting  
**LeetCode:** [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)

---

## Problem Statement

Given an integer array `nums` sorted in **non-decreasing** order, return an array of the squares of each number also sorted in non-decreasing order.

### Examples
```
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
```

### Constraints
- `1 <= nums.length <= 10⁴`
- `-10⁴ <= nums[i] <= 10⁴`
- `nums` is sorted in non-decreasing order.

**Follow-up:** Squaring and sorting is O(n log n). Can you do it in O(n)?

---

## Approach 1: Square then Sort (Beginner)
- Square every element, then sort.
- Time: O(n log n), Space: O(n) or O(1) extra depending on language.

---

## Approach 2: Two Pointers (Optimal O(n))

### Idea
Because the array is sorted, the largest squares will be at the two ends (most negative or most positive).  
Use two pointers from left and right, fill the result array from the end.

### Complexity
- **Time:** O(n)
- **Space:** O(n) for the result (required)

---

## Key Takeaways
- When a sorted array contains negatives, the extremes often hold the interesting values.
- Two-pointer from both ends is a powerful pattern for sorted arrays.
