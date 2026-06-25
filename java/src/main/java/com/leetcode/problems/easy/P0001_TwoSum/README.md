# Problem #1: Two Sum

**Difficulty:** Easy  
**Status:** ✅ Solved  
**Last Updated:** 2026-06-25  
**LeetCode Link:** [Two Sum](https://leetcode.com/problems/two-sum/)

---

## Problem Statement

Given an array of integers `nums` and an integer `target`, return the **indices** of the two numbers that add up to `target`.

You may assume that each input has **exactly one solution**, and you may **not use the same element twice**.

You can return the answer in **any order**.

### Constraints

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- **Only one valid answer exists.**

### Examples

**Example 1:**
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: nums[0] + nums[1] == 9, so we return [0, 1].
```

**Example 2:**
```
Input: nums = [3,2,4], target = 6
Output: [1,2]
Explanation: nums[1] + nums[2] == 6, so we return [1, 2].
```

**Example 3:**
```
Input: nums = [3,3], target = 6
Output: [0,1]
Explanation: Both elements have the same value but different indices.
```

---

## Approach

### Strategy: HashMap (Optimal)

The key insight is to use a **complement lookup technique**:

1. As we iterate through the array, for each number `num`, we check if its complement (`target - num`) has already been seen
2. If yes, we've found our pair! Return the indices
3. If no, store the current number and its index in a HashMap
4. Continue to the next element

### Why This Approach?

1. **Optimal Time Complexity:** O(n) instead of O(n²)
   - HashMap provides O(1) average-case lookup
   - We only need one pass through the array

2. **Straightforward Logic:** Easy to understand and implement
   - No nested loops or complex bookkeeping
   - Clear separation of concerns

3. **Handles Edge Cases:** Works correctly with:
   - Negative numbers
   - Duplicate values
   - Zero
   - Large numbers

### Algorithm Steps

```
1. Create empty HashMap
2. For each number in array:
   a. Calculate complement = target - number
   b. If complement exists in HashMap:
      - Return [index_of_complement, current_index]
   c. Else:
      - Add number -> current_index to HashMap
3. If loop completes without finding pair:
   - No solution exists (shouldn't happen per constraints)
```

### Example Walkthrough

```
nums = [2, 7, 11, 15], target = 9

Iteration 0: num=2
  complement = 9 - 2 = 7
  HashMap has 7? No
  Add: {2 -> 0}
  HashMap: {2 -> 0}

Iteration 1: num=7
  complement = 9 - 7 = 2
  HashMap has 2? Yes! At index 0
  Return [0, 1] ✓
```

---

## Complexity Analysis

### Time Complexity: O(n)

**Explanation:**
- We iterate through the array exactly once: O(n)
- Each HashMap operation (get/put) is O(1) on average
- Total: O(n) × O(1) = **O(n)**

**Why not O(n²)?**
- The brute force approach uses nested loops: for each element, search all other elements
- Our HashMap approach needs only one loop because we can lookup complements in O(1) time

### Space Complexity: O(n)

**Explanation:**
- HashMap stores at most n elements (all array values in worst case)
- No other significant data structures
- Total: **O(n)**

**Trade-off:**
- We use extra space O(n) to achieve optimal time O(n)
- This is a favorable trade-off: linear space for linear time

---

## Key Insights

### 💡 Insight 1: Complement Lookup is Powerful

Instead of comparing every pair (O(n²)), we can:
- Look up complements in constant time
- This transforms the problem from a nested loop to a single loop

### 💡 Insight 2: HashMap vs Other Data Structures

| Data Structure | Lookup Time | Why Not Use? |
|---|---|---|
| Array | O(n) | Too slow |
| Sorted Array | O(log n) | Sorting is O(n log n), indices change |
| HashSet | O(1) | Doesn't store indices, needs HashMap |
| HashMap | O(1) ✓ | Perfect! Stores both value and index |
| TreeMap | O(log n) | Overkill, HashMap is faster |

### 💡 Insight 3: Order Matters - Why We Use HashMap

We must store indices because:
- The problem asks for **indices**, not values
- If we only stored values, we couldn't return the indices
- HashMap elegantly maps values to their indices

### 💡 Insight 4: Why Single Pass Works

Key observation: We check if complement exists **before** adding current element.

This ensures:
- We don't use the same element twice
- We find the solution as soon as possible
- We maintain O(n) time complexity

---

## Edge Cases Handled

| Case | Example | How Handled | Output |
|------|---------|-------------|--------|
| **Duplicates** | [3,3], target=6 | HashMap stores latest index; still works | [0,1] ✓ |
| **Negative Numbers** | [-1, -2], target=-3 | HashMap works with any integers | [0,1] ✓ |
| **Large Numbers** | [10^9, 10^9], target=2×10^9 | Integer arithmetic handles it | Works ✓ |
| **Zero** | [0, 0], target=0 | HashMap can store 0 as key | [0,1] ✓ |
| **Unsorted** | [3,2,4], target=6 | No sorting needed | [1,2] ✓ |
| **Early Solution** | [1,2,100,200], target=3 | Found at iteration 1 | [0,1] ✓ |
| **Late Solution** | [100,200,1,2], target=3 | Still O(n) | [2,3] ✓ |

---

## Common Mistakes to Avoid

### ❌ Mistake 1: Nested Loops (Brute Force)
```java
// DON'T DO THIS - O(n²) time
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        if (nums[i] + nums[j] == target) {
            return new int[]{i, j};
        }
    }
}
```

### ❌ Mistake 2: Using HashSet (Loses Index Info)
```java
// DON'T DO THIS - Can't return indices
Set<Integer> seen = new HashSet<>();
for (int num : nums) {
    if (seen.contains(target - num)) {
        // Which index is this? We lost that info!
    }
    seen.add(num);
}
```

### ❌ Mistake 3: Sorting Array (Changes Indices)
```java
// DON'T DO THIS - Indices change after sorting
Arrays.sort(nums);
// nums = [2, 7, 11, 15] from input [7, 2, 15, 11]
// Original indices are lost!
```

### ❌ Mistake 4: Using the Same Element Twice
```java
// DON'T DO THIS
if (map.containsKey(complement)) {
    return new int[]{i, i};  // WRONG! Using index i twice
}
```

### ✅ Correct Approach
```java
// DO THIS
Map<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};  // Different indices ✓
    }
    map.put(nums[i], i);
}
```

---

## Related Problems

| # | Title | Difficulty | Why Related |
|---|-------|-----------|-------------|
| 15 | [3Sum](https://leetcode.com/problems/3sum/) | Medium | Extension: find 3 numbers |
| 18 | [4Sum](https://leetcode.com/problems/4sum/) | Medium | Extension: find 4 numbers |
| 16 | [3Sum Closest](https://leetcode.com/problems/3sum-closest/) | Medium | Similar HashMap technique |
| 167 | [Two Sum II (Sorted)](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Medium | Two-pointer approach instead |
| 170 | [Two Sum III (Design)](https://leetcode.com/problems/two-sum-iii-data-structure-design/) | Easy | Use HashMap for lookups |

---

## Testing

Run the tests with Maven:
```bash
mvn test -Dtest=SolutionTest
```

Or run the interactive program:
```bash
javac java/problems/easy/P0001_TwoSum/Solution.java
java -cp java/problems/easy/P0001_TwoSum com.leetcode.problems.easy.Solution
```

---

## Interview Tips

1. **Start with brute force:** Explain O(n²) nested loop approach first
2. **Identify bottleneck:** "We're checking every pair, which is wasteful"
3. **Introduce optimization:** "Can we check complements faster?"
4. **Present HashMap solution:** "Yes! With a HashMap, lookup is O(1)"
5. **Code carefully:** Write the solution while explaining
6. **Test thoroughly:** Walk through examples and edge cases
7. **Discuss trade-offs:** Time vs. space, readability vs. optimization

---

## LeetCode Notes

- **Acceptance Rate:** ~50% (common interview question)
- **Difficulty:** Easy (but tests fundamental data structure knowledge)
- **Key Learning:** HashMap usage and algorithm optimization
- **Follow-ups:** 
  - What if array is sorted?
  - What if we need all pairs (not just first)?
  - What about 3Sum, 4Sum variants?

---

## References

- [LeetCode Problem Page](https://leetcode.com/problems/two-sum/)
- [Discussion Section](https://leetcode.com/problems/two-sum/discuss/)
- [Time/Space Complexity Guide](../../docs/COMPLEXITY_GUIDE.md)
- [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)

---

**Last Review:** 2026-06-25  
**Status:** Production Ready ✅
