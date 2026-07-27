# 14. Longest Common Prefix

**Difficulty:** Easy  
**Topics:** String, Trie  
**LeetCode:** [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)

---

## Problem Statement

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

### Examples
```
Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

### Constraints
- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` consists of only lowercase English letters if it is non-empty.

---

## Approach 1: Horizontal Scanning (Beginner)

Take the first string as the initial prefix.  
Compare it with each subsequent string and shorten the prefix until it matches the beginning of that string.

- Time: O(S) where S = sum of all characters
- Space: O(1)

---

## Approach 2: Vertical Scanning

Compare characters column by column.  
Stop at the first mismatch or when any string ends.

Often slightly faster in practice because it can terminate early.

---

## Approach 3: Divide and Conquer / Trie (Advanced)

- Divide the array into two halves, find LCP of each half, then LCP of the two results.
- Or build a Trie and walk until a node has more than one child or is end-of-word.

---

## Edge Cases
- Empty array / empty strings
- Single string → the string itself
- No common prefix at all
- All strings identical

---

## Key Takeaways
- Horizontal scanning is the simplest to implement and understand.
- Vertical scanning can short-circuit earlier.
- This problem is a gentle introduction to string processing and Trie thinking.
