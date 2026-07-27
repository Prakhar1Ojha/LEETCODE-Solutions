# 35. Search Insert Position

**Difficulty:** Easy  
**Topics:** Array, Binary Search  
**LeetCode:** [Search Insert Position](https://leetcode.com/problems/search-insert-position/)

---

## Problem Statement

Given a sorted array of distinct integers and a target value, return the index if the target is found.  
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with `O(log n)` runtime complexity.

### Examples
```
Input: nums = [1,3,5,6], target = 5
Output: 2

Input: nums = [1,3,5,6], target = 2
Output: 1

Input: nums = [1,3,5,6], target = 7
Output: 4
```

### Constraints
- `1 <= nums.length <= 10⁴`
- `-10⁴ <= nums[i] <= 10⁴`
- `nums` contains distinct values sorted in ascending order.
- `-10⁴ <= target <= 10⁴`

---

## Approach: Binary Search

### Idea
Standard binary search.  
When the loop ends, `left` is the insertion point (the first index where `nums[i] >= target`).

### Complexity
- **Time:** O(log n)
- **Space:** O(1)

---

## Key Takeaways
- Classic binary-search template.
- The final value of `left` (or `low`) is exactly the insertion index.
- Very common interview question to verify binary-search mastery.
