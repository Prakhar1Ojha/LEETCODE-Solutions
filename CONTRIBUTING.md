# Contributing to LEETCODE-Solutions

Thank you for your interest in contributing! This document provides guidelines for adding solutions to this repository.

## Solution Format Requirements

Each solution must include the following:

1. **Problem ID & Title** - Use LeetCode problem number
2. **Difficulty Level** - Easy, Medium, or Hard
3. **Optimal Approach** - Clear explanation of the strategy
4. **Time & Space Complexity** - Big O analysis
5. **Complete Javadoc** - Problem description and approach
6. **Test Cases** - JUnit tests with edge cases
7. **Documentation** - README.md with examples

## Folder Structure

Organize solutions by difficulty level:

```
java/problems/
├── easy/
│   └── P{ID}_{TITLE}/
│       ├── Solution.java
│       ├── SolutionTest.java
│       └── README.md
├── medium/
│   └── ...
└── hard/
    └── ...
```

### Naming Conventions

- **Folders:** `P{PROBLEM_ID}_{PROBLEM_TITLE}` (e.g., `P0001_TwoSum`)
- **Classes:** `Solution` (main implementation)
- **Test Class:** `SolutionTest` (JUnit tests)
- **Package:** `com.leetcode.problems.{difficulty}` (e.g., `com.leetcode.problems.easy`)

## Code Standards

### Required:
- [ ] Package declaration at top of file
- [ ] Complete Javadoc comments for all public methods
- [ ] Clear variable names (no single letters except loop indices)
- [ ] Proper exception handling with meaningful messages
- [ ] Try-with-resources for resource management
- [ ] JUnit 4 test class with minimum 3 test cases
- [ ] `Objects.requireNonNull()` for null validation

### Example Structure:

See [docs/SOLUTION_TEMPLATE.md](docs/SOLUTION_TEMPLATE.md) for the full `Solution.java`, `SolutionTest.java`, and `README.md` templates to copy from when adding a new problem. Don't duplicate the templates here — that file is the single source of truth.

## Test Requirements

Every solution must include a `SolutionTest.java` file with:

- **Happy Path:** Basic example from problem statement
- **Edge Cases:** Empty input, single element, large values
- **Invalid Input:** Null, wrong types (throw exception tests)
- **Performance:** Test with larger inputs

See the test template in [docs/SOLUTION_TEMPLATE.md](docs/SOLUTION_TEMPLATE.md#file-2-solutiontestjava).

## Documentation (README.md)

Each problem folder must include `README.md` documenting problem statement, approach, complexity analysis, key insights, examples, and related problems. See the README template in [docs/SOLUTION_TEMPLATE.md](docs/SOLUTION_TEMPLATE.md#file-3-readmemd).

## Commit Message Format

```
[Java] P{ID}: {TITLE} - {Brief description}

Example:
[Java] P0001: Two Sum - HashMap approach for O(n) solution
```

## Pull Request Process

1. Create a feature branch: `feature/p{ID}_{title}`
2. Add your solution following the above guidelines
3. Run tests locally: `mvn clean test`
4. Ensure no compiler warnings
5. Push to your fork and create a PR
6. Respond to code review feedback
7. Ensure CI/CD pipeline passes

## One Solution Per Problem

We prefer ONE optimal solution per problem. If multiple approaches have significantly different trade-offs, discuss in the README.md but implement only the best one in Solution.java.

## Questions?

Open an issue for discussions or email the maintainer.

Thank you for contributing! 🎉
