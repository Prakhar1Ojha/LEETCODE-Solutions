# Time & Space Complexity Guide

A quick reference for analyzing algorithm complexity.

## Big O Notation - Time Complexity

| Notation | Name | Example | Feasible Size |
|----------|------|---------|----------------|
| **O(1)** | Constant | Array access by index | Unlimited |
| **O(log n)** | Logarithmic | Binary search | 10^9 |
| **O(n)** | Linear | Simple loop | 10^8 |
| **O(n log n)** | Linearithmic | Merge sort, heap sort | 10^7 |
| **O(n²)** | Quadratic | Nested loops | 10^4 |
| **O(n³)** | Cubic | Triple nested loop | 500 |
| **O(2^n)** | Exponential | Recursion without memo | 20 |
| **O(n!)** | Factorial | Permutations | 11 |

## Complexity Analysis Examples

### O(1) - Constant Time
```java
// Direct access
int value = array[0];

// HashMap lookup
boolean exists = map.containsKey(key);

// Single operation
int result = a + b;
```

### O(n) - Linear Time
```java
// Single loop
for (int i = 0; i < n; i++) {
    process(array[i]);
}

// Linear search
for (int num : array) {
    if (num == target) return true;
}
```

### O(n log n) - Linearithmic Time
```java
// Merge sort
mergeSort(array);

// Heap operations with n elements
for (int i = 0; i < n; i++) {
    heap.add(element);  // O(log n) per addition
}
```

### O(n²) - Quadratic Time
```java
// Nested loops
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        process(array[i], array[j]);
    }
}

// Bubble sort
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n - 1; j++) {
        if (array[j] > array[j + 1]) {
            swap(array[j], array[j + 1]);
        }
    }
}
```

### O(2^n) - Exponential Time
```java
// Recursion without memoization
int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
    // Calls: 2^n
}
```

## Space Complexity Analysis

| What Uses Space | Complexity | Example |
|-----------------|-----------|----------|
| No extra space | O(1) | In-place swap |
| Single variable | O(1) | Counter |
| Array of size n | O(n) | Copy of input |
| HashMap with n items | O(n) | Frequency map |
| Recursion depth n | O(n) | Stack frames |
| 2D array | O(n²) | Grid |

## Examples

### Two Sum Problem

**Brute Force Approach:**
```java
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        if (nums[i] + nums[j] == target) {
            return new int[]{i, j};
        }
    }
}
```
- **Time:** O(n²) - nested loops
- **Space:** O(1) - only temp variables

**HashMap Approach:**
```java
Map<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
    }
    map.put(nums[i], i);
}
```
- **Time:** O(n) - single loop, O(1) HashMap ops
- **Space:** O(n) - HashMap stores up to n items

## LeetCode Context

When you see a problem constraint:
- `n <= 10^5` → O(n) or O(n log n) solutions accepted
- `n <= 10^4` → O(n²) might work
- `n <= 500` → O(n³) is feasible
- `n <= 20` → O(2^n) is feasible

## How to Analyze Your Code

### Step 1: Identify Loops
```java
for (int i = 0; i < n; i++) {           // O(n)
    for (int j = 0; j < n; j++) {       // O(n) nested
        operation();                     // O(1)
    }
}
// Total: O(n²)
```

### Step 2: Identify Collections
```java
Set<Integer> set = new HashSet<>();
for (int i = 0; i < n; i++) {
    set.add(nums[i]);                   // O(1) per add
}
// Total: O(n)
```

### Step 3: Identify Recursive Calls
```java
int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n-1) + fibonacci(n-2);
    // Branching factor: 2, depth: n
    // Total calls: 2^n
}
// Total: O(2^n)
```

### Step 4: Combine
```java
for (int i = 0; i < n; i++) {          // O(n)
    set.contains(nums[i]);               // O(1)
    Collections.sort(temp);              // O(k log k) where k = size of temp
}
// Total: O(n * k log k) - depends on context
```

## Common Mistakes

❌ **Mistake:** Counting operations instead of orders
```java
// NOT O(3n) - we drop constants
for (int i = 0; i < n; i++) step1();
for (int i = 0; i < n; i++) step2();
for (int i = 0; i < n; i++) step3();
// This is O(n)
```

❌ **Mistake:** Ignoring inner loop complexity
```java
for (int i = 0; i < n; i++) {
    Arrays.sort(arr);  // O(n log n) EACH TIME
}
// Total: O(n² log n) - NOT O(n log n)!
```

✅ **Correct:** Always multiply nested loops
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        operation();  // O(1) in constant time
    }
}
// Total: O(n) * O(n) = O(n²)
```

## Quick Decision Tree

```
Does your code have loops?
├─ Yes, single loop? → O(n)
├─ Yes, nested loops? → O(n²) or more depending on nesting
├─ No, recursion? → Analyze branching and depth
└─ No recursion/loops? → Check if you're using Collections

Using HashMap/HashSet?
├─ add/remove/get → O(1)
├─ containsKey → O(1)
└─ (on average, O(n) worst case)

Using Arrays.sort()?
└─ O(n log n)

Using nested Collections operations?
└─ Multiply complexities
```

## Reference: Common Data Structure Operations

| Operation | Array | ArrayList | HashMap | HashSet | TreeMap |
|-----------|-------|-----------|---------|---------|----------|
| Access | O(1) | O(1) | - | - | - |
| Search | O(n) | O(n) | O(1) | O(1) | O(log n) |
| Insert | O(n) | O(n) | O(1) | O(1) | O(log n) |
| Delete | O(n) | O(n) | O(1) | O(1) | O(log n) |
| Sort | O(n log n) | O(n log n) | - | - | - |

Use this table when deciding which data structure to use!
