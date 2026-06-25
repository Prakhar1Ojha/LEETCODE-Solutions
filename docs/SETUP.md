# Setup & Running Instructions

## Prerequisites

- **Java:** JDK 11 or higher
- **Maven:** 3.6 or higher (optional, for running all tests at once)
- **Git:** Latest version

### Install Java

**On macOS (using Homebrew):**
```bash
brew install openjdk@11
```

**On Ubuntu/Debian:**
```bash
sudo apt update
sudo apt install openjdk-11-jdk
```

**On Windows:**
Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or use [Chocolatey](https://chocolatey.org/):
```bash
choco install openjdk11
```

Verify installation:
```bash
java -version
```

### Install Maven (Optional)

**On macOS:**
```bash
brew install maven
```

**On Ubuntu/Debian:**
```bash
sudo apt install maven
```

**On Windows:**
Download from [Maven](https://maven.apache.org/download.cgi) and add to PATH.

Verify installation:
```bash
mvn --version
```

## Running Individual Solutions

### Step 1: Navigate to Problem Directory
```bash
cd java/problems/easy/P0001_TwoSum
```

### Step 2: Compile
```bash
javac -d . Solution.java
```

### Step 3: Run
```bash
java com.leetcode.problems.easy.Solution
```

You'll be prompted for input:
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

## Running Tests

### Option 1: Using Maven (Recommended)

Run all tests:
```bash
mvn clean test
```

Run tests for specific module:
```bash
cd java
mvn clean test
```

Run single test class:
```bash
mvn test -Dtest=SolutionTest
```

### Option 2: Using JUnit Directly

Compile:
```bash
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar Solution.java SolutionTest.java
```

Run:
```bash
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore SolutionTest
```

## Building the Project

```bash
mvn clean package
```

This will:
- Compile all Java files
- Run all tests
- Create JAR files
- Generate reports

## Code Quality Checks

### Run Style Checker
```bash
mvn checkstyle:check
```

### Run Validation Script
```bash
./scripts/validate-solutions.sh
```

## Troubleshooting

### "Command 'javac' not found"
Java is not in your PATH. Verify installation and add JDK bin folder to PATH.

### "Maven is not recognized"
Same as above for Maven installation.

### Tests fail but code compiles
Check that all dependencies are in pom.xml (JUnit, Hamcrest).

### "NoClassDefFoundError: org/junit/Test"
Download JUnit JAR and add to classpath:
```bash
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar SolutionTest.java
```

## IDE Setup

### IntelliJ IDEA
1. Open project: `File > Open > Select LEETCODE-Solutions folder`
2. Ensure Java SDK is configured: `Project Settings > Project > SDK`
3. Maven should auto-import pom.xml
4. Run tests: Right-click test class > Run

### VS Code
1. Install Extension Pack for Java
2. Open folder: `File > Open Folder`
3. Run tests via CodeLens above test methods

### Eclipse
1. Import as Maven project: `File > Import > Existing Maven Projects`
2. Right-click project > Maven > Update Project
3. Run tests: Right-click test > Run As > JUnit Test

## Next Steps

- Read [SOLUTION_TEMPLATE.md](./SOLUTION_TEMPLATE.md) for template
- Check [CONTRIBUTING.md](../CONTRIBUTING.md) for guidelines
- Browse existing solutions in `java/problems/`

Happy solving! 🚀
