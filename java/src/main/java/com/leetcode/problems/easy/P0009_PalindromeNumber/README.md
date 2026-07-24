# Problem #9: Palindrome Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-success)
![Language](https://img.shields.io/badge/Language-Java-orange)
![Time](https://img.shields.io/badge/Time-O(log₁₀n)-blue)
![Space](https://img.shields.io/badge/Space-O(1)-brightgreen)

**Status:** ✅ Solved

---

# Overview

A palindrome number reads exactly the same from left to right and right to left.

Your task is to determine whether the given integer remains unchanged when its digits are reversed.

The solution should be efficient and should avoid unnecessary conversions whenever possible.

---

# Pattern

- Math
- Integer Manipulation
- Reverse Number
- Digit Extraction

---

# Approaches

## Approach 1 — Convert to String

### Idea

Convert the integer into a string and compare characters from both ends.

If every corresponding pair matches, the number is a palindrome.

### Advantages

- Very easy to understand
- Simple implementation

### Drawbacks

- Requires extra memory
- Doesn't utilize mathematical properties

### Complexity

| Time | Space |
|------|------|
| O(d) | O(d) |

where **d** is the number of digits.

---

## Approach 2 — Reverse Half of the Number (Optimal)

### Intuition

Instead of reversing the complete number, only reverse the second half.

Why?

Reversing the whole number may overflow for larger integers.

Once the reversed half becomes greater than or equal to the remaining half, we've processed enough digits.

---

# Key Observations

### Negative Numbers

```
-121
```

cannot be palindromes because the minus sign appears only on one side.

---

### Numbers Ending with Zero

Examples

```
10
120
1000
```

These cannot be palindromes because the reversed version would begin with zero.

The only exception is

```
0
```

which is itself a palindrome.

---

# Algorithm

```
If number is negative
    return false

If number ends with zero but isn't zero
    return false

Create reversedHalf = 0

While number > reversedHalf

    Take last digit

    Append digit to reversedHalf

    Remove last digit from original number

Finally

If both halves are equal
    return true

For odd-length numbers

Ignore the middle digit by dividing reversedHalf by 10

Compare again.
```

---

# Dry Run

Input

```
121
```

| Original | Reversed Half |
|-----------|---------------|
|121|0|
|12|1|
|1|12|

Now

```
1 == 12 / 10
```

```
1 == 1
```

Answer

```
True
```

---

Example

```
1221
```

| Original | Reversed Half |
|-----------|---------------|
|1221|0|
|122|1|
|12|12|

Both halves are equal.

Answer

```
True
```

---

# Java Solution

```java
class Solution {

    public boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int reversedHalf = 0;

        while (x > reversedHalf) {

            reversedHalf = reversedHalf * 10 + x % 10;

            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }
}
```

---

# Complexity Analysis

| Metric | Value |
|--------|------|
| Time Complexity | O(log₁₀n) |
| Space Complexity | O(1) |

### Why O(log₁₀n)?

Every iteration removes one decimal digit.

The number of digits in an integer is

```
log₁₀(n)
```

Therefore the loop executes only once per digit.

---

# Why Reverse Only Half?

Suppose

```
123454321
```

We don't need to reverse all nine digits.

After reversing four digits

```
1234
```

and

```
1234
```

we already know the answer.

For odd-length numbers, simply ignore the middle digit.

This reduces unnecessary work and completely avoids integer overflow.

---

# Edge Cases

| Input | Output | Reason |
|--------|--------|--------|
|121|True|Reads same both ways|
|-121|False|Negative sign|
|10|False|Leading zero after reverse|
|0|True|Single digit|
|7|True|Single digit|
|1221|True|Even digits|
|12321|True|Odd digits|
|12345|False|Digits differ|

---

# Common Mistakes

## ❌ Reversing Entire Number

May overflow for larger integers.

---

## ❌ Ignoring Negative Numbers

```
-121
```

is never a palindrome.

---

## ❌ Forgetting Numbers Ending in Zero

```
10
```

is not

```
01
```

---

## ❌ Comparing Before Processing Enough Digits

Always continue until

```
reversedHalf >= originalHalf
```

---

# Interview Discussion

### Brute Force

Convert integer to string.

Compare characters from both ends.

Easy but uses extra memory.

---

### Optimal

Reverse only half of the digits.

No extra space.

Overflow safe.

Cleaner mathematical solution.

---

# Follow-up Questions

### Can this be solved without converting to String?

Yes.

The optimal mathematical solution avoids any string conversion.

---

### Why reverse only half?

It prevents overflow and performs fewer operations.

---

### Can integer overflow happen?

Not in the optimal solution because only half of the digits are reversed.

---

# Key Takeaways

✅ Think mathematically before converting data types.

✅ Reverse only what is necessary.

✅ Pay attention to special cases like negatives and trailing zeros.

✅ Efficient solutions often come from identifying unnecessary work.

---

# Related Problems

| Problem | Concept |
|----------|----------|
| Reverse Integer | Integer Manipulation |
| Plus One | Digit Operations |
| Add Digits | Number Properties |
| Happy Number | Mathematical Simulation |

---

# Tags

```
Math
Easy
Palindrome
Digit Manipulation
Reverse Integer
```

---

# Final Thoughts

This problem looks simple at first glance, but it's an excellent interview question because it tests whether you can recognize a mathematical optimization instead of relying on string conversion.

The reverse-half approach is both elegant and efficient, making it the preferred solution for interviews.

---

**Status:** ✅ Solved
