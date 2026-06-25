# Java LeetCode Solutions

**Status:** 🚀 In Progress | **Last Updated:** 2026-06-25

Collection of LeetCode problem solutions implemented in Java with comprehensive explanations, optimal algorithms, and complete test coverage.

---

## 📊 Progress Statistics

| Difficulty | Count | Percentage |
|------------|-------|------------|
| **Easy** | 1 | 100% |
| **Medium** | 0 | 0% |
| **Hard** | 0 | 0% |
| **TOTAL** | **1** | — |

**Overall Progress:** 1 of 3,000+ problems

---

## ✅ Solved Problems

### Easy (1 problem)

| # | Title | Topics | Complexity | Solution |
|---|-------|--------|-----------|----------|
| 1 | **Two Sum** | Array, HashMap | [O(n)/O(n)](./problems/easy/P0001_TwoSum/README.md) | [View](./problems/easy/P0001_TwoSum/Solution.java) |

### Medium (Coming Soon)

*No problems solved yet.*

### Hard (Coming Soon)

*No problems solved yet.*

---

## 📂 Folder Structure

```
java/
├── README.md                           # This file
├── pom.xml                            # Maven configuration (coming soon)
│
├── problems/
│   ├── easy/
│   │   ├── P0001_TwoSum/
│   │   │   ├── Solution.java          # Main solution code
│   │   │   ├── SolutionTest.java      # JUnit test suite
│   │   │   └── README.md              # Problem explanation & guide
│   │   └── ...
│   │
│   ├── medium/
│   │   └── ...
│   │
│   └── hard/
│       └── ...
│
└── utils/
    ├── ListNode.java                  # Shared: Linked List node (coming)
    └── TreeNode.java                  # Shared: Binary Tree node (coming)
```

---

## 🚀 Quick Start

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher (optional)

### Running a Solution

**Interactive Mode:**
```bash
cd java/problems/easy/P0001_TwoSum
javac -d . Solution.java
java com.leetcode.problems.easy.Solution
```

Then follow the prompts:
```
Enter array size: 4
Enter array elements:
2
7
11
15
Enter target sum: 9
Indices: [0, 1]
```

### Running Tests

**Using Maven:**
```bash
cd java
mvn clean test
```

**Using JUnit directly:**
```bash
cd java/problems/easy/P0001_TwoSum
javac -cp .:junit-4.13.2.jar SolutionTest.java
java -cp .:junit-4.13.2.jar org.junit.runner.JUnitCore SolutionTest
```

---

## 📖 Learning Path

### Recommended Order

Solve problems in this order to build fundamental skills:

1. **Two Sum** (HashMap, brute force optimization)
2. *3Sum* (Two pointers, sorting)
3. *Two Sum II* (Two pointers on sorted array)
4. *Container With Most Water* (Two pointers)
5. *Valid Parentheses* (Stack)
6. *Reverse Linked List* (Linked lists)
7. *Binary Tree Level Order Traversal* (BFS)
8. *LRU Cache* (HashMap + Doubly Linked List)

---

## 🎯 Solution Template

Each solution follows this structure:

### Solution.java
```java
package com.leetcode.problems.{difficulty};

/**
 * LeetCode Problem #{ID}: {TITLE}
 * 
 * Problem: {Brief description}
 * Approach: {Algorithm explanation}
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */
public class Solution {
    public ReturnType solve(InputType input) {
        // Implementation
    }
    
    public static void main(String[] args) {
        // Interactive testing
    }
}
```

### SolutionTest.java
```java
import org.junit.*;
import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void testBasicCase() { ... }
    
    @Test
    public void testEdgeCase() { ... }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput() { ... }
}
```

### README.md
- Problem statement
- Approach explanation
- Complexity analysis
- Example walkthrough
- Edge cases
- Related problems

---

## 📝 Code Standards

All solutions follow these conventions:

✅ **Required**
- Package declaration: `com.leetcode.problems.{difficulty}`
- Comprehensive Javadoc comments
- JUnit 4 test suite with minimum 3 tests
- Clear variable names (no single letters except loop indices)
- Proper exception handling with meaningful messages
- Try-with-resources for stream/scanner management

✅ **Preferred**
- Multiple test cases: happy path, edge cases, error cases
- Performance tests for large inputs
- Example walkthrough in README
- Comparison with alternative approaches
- Related problems section

❌ **Avoid**
- Default package (always use package declaration)
- Single-letter variable names (except i, j in loops)
- Missing null checks
- Resource leaks (unclosed streams/scanners)
- Hardcoded test data in main method

---

## 🔧 Tools & Technologies

| Tool | Version | Purpose |
|------|---------|----------|
| **Java** | 11+ | Language |
| **Maven** | 3.6+ | Build & dependency management |
| **JUnit** | 4.13.2 | Unit testing |
| **Hamcrest** | 1.3 | Assertion library |

---

## ✅ Checklist for New Solution

When adding a new problem, ensure:

- [ ] Create directory: `problems/{difficulty}/P{ID}_{TITLE}/`
- [ ] Implement `Solution.java` with package declaration
- [ ] Write `SolutionTest.java` with 5+ test cases
- [ ] Create `README.md` with problem explanation
- [ ] Code compiles without warnings
- [ ] All tests pass: `mvn clean test`
- [ ] No unused imports
- [ ] Clear variable names
- [ ] Proper error handling
- [ ] Performance verified (if applicable)
- [ ] Documentation complete

---

## 🤝 Contributing

Want to add more solutions? See [CONTRIBUTING.md](../../CONTRIBUTING.md) for:
- Code standards
- Folder structure
- Test requirements
- Commit message format
- Pull request process

---

## 📚 Resources

- [LeetCode Java Docs](https://leetcode.com/)
- [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/)
- [Big O Complexity Guide](../../docs/COMPLEXITY_GUIDE.md)
- [Setup Instructions](../../docs/SETUP.md)
- [Solution Template](../../docs/SOLUTION_TEMPLATE.md)

---

## 🎓 Learning Objectives

By solving these problems, you'll learn:

1. **Data Structures:**
   - Arrays, Linked Lists, Trees, Graphs
   - HashMaps, HashSets, Heaps, Queues

2. **Algorithms:**
   - Searching & Sorting
   - Two Pointers, Sliding Window
   - Dynamic Programming
   - Graph Traversal (BFS, DFS)

3. **Problem-Solving:**
   - How to approach unfamiliar problems
   - Trade-offs between time and space
   - Optimization techniques

4. **Coding Practices:**
   - Clean, readable code
   - Comprehensive testing
   - Documentation
   - Edge case handling

---

## 📝 Notes

- Solutions are optimized for clarity and learning, not code golf
- Each problem includes explanation of why the approach is optimal
- Alternative approaches discussed when relevant
- Focus on understanding, not memorization

---

**Last Updated:** 2026-06-25  
**Maintained by:** Prakhar Ojha  
**License:** MIT
