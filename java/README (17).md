# 20. Valid Parentheses

**Difficulty:** Easy  
**Topics:** String, Stack  
**LeetCode:** [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

---

## Problem Statement

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

### Examples
```
Input: s = "()"
Output: true

Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false

Input: s = "([)]"
Output: false

Input: s = "{[]}"
Output: true
```

### Constraints
- `1 <= s.length <= 10⁴`
- `s` consists of parentheses only `'()[]{}'`.

---

## Approach: Stack

### Idea
- When we see an **opening** bracket → push it onto the stack.
- When we see a **closing** bracket → the top of the stack must be the matching opening bracket. Pop it.
- At the end the stack must be empty.

### Complexity
- **Time:** O(n)
- **Space:** O(n) in worst case (all opening brackets)

---

## Edge Cases
- Empty string (though constraints say length ≥ 1)
- Only opening brackets
- Only closing brackets
- Correctly nested vs interleaved incorrectly (`([)]`)

---

## Key Takeaways
- Classic stack problem — perfect introduction to the stack data structure.
- Mapping closing → opening makes the code clean.
- Always check for empty stack before peeking/popping.
