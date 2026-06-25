# Solution Template

Use this template when creating a new problem solution.

## Directory & File Creation

```bash
# Create directory for new problem
mkdir -p java/src/main/java/com/leetcode/problems/{difficulty}/P{ID}_{TITLE}
cd java/src/main/java/com/leetcode/problems/{difficulty}/P{ID}_{TITLE}

# Create three files:
# 1. Solution.java (your code)
# 2. SolutionTest.java (JUnit tests)
# 3. README.md (documentation)
```

## File 1: Solution.java

```java
package com.leetcode.problems.{difficulty};

import java.util.*;
import java.util.Objects;

/**
 * LeetCode Problem #{ID}: {TITLE}
 * 
 * Problem Statement:
 * {Brief description of what the problem asks}
 * 
 * Approach:
 * {Explain the algorithm and data structures used}
 * {Why this approach is optimal}
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Example:
 * Input: ...
 * Output: ...
 */
public class Solution {
    
    /**
     * Description of main solving method.
     * 
     * @param param1 description
     * @param param2 description
     * @return what is returned
     * @throws IllegalArgumentException if validation fails
     */
    public ReturnType solve(ParamType param1, ParamType param2) {
        Objects.requireNonNull(param1, "param1 cannot be null");
        Objects.requireNonNull(param2, "param2 cannot be null");
        
        // Input validation
        if (param1.isEmpty()) {
            throw new IllegalArgumentException("param1 cannot be empty");
        }
        
        // Implementation here
        
        return result;
    }
    
    /**
     * Helper method description (if needed).
     */
    private void helperMethod() {
        // Implementation
    }
    
    /**
     * Main method for interactive testing.
     * Users can input test cases and see results.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Read input
            System.out.print("Enter input: ");
            ParamType input = readInput(scanner);
            
            // Solve
            Solution solution = new Solution();
            ReturnType result = solution.solve(input);
            
            // Display result
            System.out.println("Result: " + result);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
    
    /**
     * Helper to read input from user.
     */
    private static ParamType readInput(Scanner scanner) {
        // Implementation
        return input;
    }
}
```

## File 2: SolutionTest.java

```java
package com.leetcode.problems.{difficulty};

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for Problem #{ID}: {TITLE}
 */
public class SolutionTest {
    
    private Solution solution;
    
    @Before
    public void setUp() {
        solution = new Solution();
    }
    
    /**
     * Test basic example from problem statement.
     */
    @Test
    public void testBasicExample() {
        // Setup
        ParamType input = /* basic example */;
        ReturnType expected = /* expected result */;
        
        // Execute
        ReturnType actual = solution.solve(input);
        
        // Assert
        assertEquals(expected, actual);
    }
    
    /**
     * Test edge case: empty input.
     */
    @Test
    public void testEmptyInput() {
        ParamType input = /* empty */;
        ReturnType expected = /* expected */;
        
        ReturnType actual = solution.solve(input);
        
        assertEquals(expected, actual);
    }
    
    /**
     * Test edge case: single element.
     */
    @Test
    public void testSingleElement() {
        ParamType input = /* single element */;
        ReturnType expected = /* expected */;
        
        ReturnType actual = solution.solve(input);
        
        assertEquals(expected, actual);
    }
    
    /**
     * Test with large input (performance).
     */
    @Test
    public void testLargeInput() {
        ParamType input = /* large input */;
        ReturnType expected = /* expected */;
        
        long start = System.currentTimeMillis();
        ReturnType actual = solution.solve(input);
        long duration = System.currentTimeMillis() - start;
        
        assertEquals(expected, actual);
        System.out.println("Large input completed in " + duration + "ms");
    }
    
    /**
     * Test invalid input: null parameter.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        solution.solve(null);
    }
    
    /**
     * Test invalid input: invalid constraint violation.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput() {
        ParamType invalid = /* violates constraint */;
        solution.solve(invalid);
    }
}
```

## File 3: README.md

```markdown
# Problem #{ID}: {TITLE}

**Difficulty:** Easy / Medium / Hard  
**Status:** ✅ Solved  
**Last Updated:** {Date}

## Problem Statement

{Copy the exact problem statement from LeetCode}

### Constraints
- Constraint 1
- Constraint 2
- Constraint 3

### Examples

**Example 1:**
```
Input: ...
Output: ...
Explanation: ...
```

**Example 2:**
```
Input: ...
Output: ...
Explanation: ...
```

## Approach

### Strategy
{Explain your approach in clear, simple terms}

### Why This Approach?
- {Reason 1 for optimality}
- {Reason 2}
- {How it avoids common pitfalls}

### Algorithm Steps
1. Step 1: ...
2. Step 2: ...
3. Step 3: ...

## Complexity Analysis

### Time Complexity
**O(?)** because:
- {Explanation}

### Space Complexity
**O(?)** because:
- {Explanation}

## Key Insights

- **Insight 1:** {Key learning from this problem}
- **Insight 2:** {Common mistake to avoid}
- **Insight 3:** {Alternative approach trade-off}

## Edge Cases Handled

| Case | Input | Output | Reason |
|------|-------|--------|--------|
| Empty | ... | ... | ... |
| Single Element | ... | ... | ... |
| All Same | ... | ... | ... |
| Negative Numbers | ... | ... | ... |
| Large Input | ... | ... | Performance |

## Related Problems

- Problem #{ID}: {Title} - {Relationship}
- Problem #{ID}: {Title} - {Relationship}

## LeetCode Resources

- [Problem Link](https://leetcode.com/problems/{problem-slug})
- [Discuss Section](https://leetcode.com/problems/{problem-slug}/discuss)

## Notes for Future Reference

{Any additional notes, alternative approaches, or things learned}
```

## Directory Structure After Creation

```
java/src/main/java/com/leetcode/problems/easy/P0001_TwoSum/
├── Solution.java          (150-300 lines)
├── SolutionTest.java      (100-200 lines)
└── README.md              (200-400 lines)
```

## Checklist Before Committing

- [ ] Code compiles without warnings
- [ ] All tests pass: `mvn clean test`
- [ ] Code style is consistent
- [ ] Javadoc comments are complete
- [ ] README.md is comprehensive
- [ ] No unused imports
- [ ] Exception handling is proper
- [ ] Variable names are clear (no `x`, `y`, `temp`)
- [ ] No hardcoded test data in Solution.java
- [ ] Main method is optional (used only for CLI)

## Tips

1. **Start with understanding:** Read the problem carefully multiple times
2. **Pseudocode first:** Write algorithm in plain English before coding
3. **Test-driven:** Write tests first, then implement
4. **Comments:** Explain "why", not "what" (code shows what)
5. **Variable naming:** Use meaningful names (`complement`, not `c`)
6. **Early exit:** Validate inputs at the start
7. **Documentation:** Treat README as teaching material

Happy coding! 🎯
