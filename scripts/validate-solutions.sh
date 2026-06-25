#!/bin/bash

# LeetCode Solutions - Validation Script
# Validates all Java solutions for quality and correctness
# Usage: ./scripts/validate-solutions.sh

set -e  # Exit on error

echo "======================================================================"
echo "  🔍  LeetCode Solutions Validation Script"
echo "======================================================================"
echo ""

# Color codes
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

ERRORS=0
WARNINGS=0

# ============ Step 1: Check Java installation ============
echo "[1/6] Checking Java installation..."
if ! command -v java &> /dev/null; then
    echo -e "${RED}✗ Java not found. Please install Java 11 or higher.${NC}"
    exit 1
fi

JAVA_VERSION=$(java -version 2>&1 | grep -oP 'version "[^"]+' | grep -oP '[0-9]+' | head -1)
echo -e "${GREEN}✓ Java ${JAVA_VERSION} installed${NC}"
echo ""

# ============ Step 2: Check Maven installation ============
echo "[2/6] Checking Maven installation..."
if ! command -v mvn &> /dev/null; then
    echo -e "${YELLOW}⚠ Maven not found. Skipping Maven checks. (Optional)${NC}"
else
    echo -e "${GREEN}✓ Maven installed${NC}"
fi
echo ""

# ============ Step 3: Validate package declarations ============
echo "[3/6] Validating package declarations..."
MISSING_PACKAGES=$(find java/problems -name "*.java" -type f ! -name "*Test.java" -exec grep -L "^package" {} \; 2>/dev/null | wc -l)

if [ "$MISSING_PACKAGES" -gt 0 ]; then
    echo -e "${RED}✗ Found $MISSING_PACKAGES files without package declarations${NC}"
    find java/problems -name "*.java" -type f ! -name "*Test.java" -exec grep -L "^package" {} \; 2>/dev/null
    ((ERRORS++))
else
    echo -e "${GREEN}✓ All files have package declarations${NC}"
fi
echo ""

# ============ Step 4: Validate Javadoc ============
echo "[4/6] Validating Javadoc comments..."
MISSING_JAVADOC=$(find java/problems -name "Solution.java" -type f -exec grep -L "/\*\*" {} \; 2>/dev/null | wc -l)

if [ "$MISSING_JAVADOC" -gt 0 ]; then
    echo -e "${RED}✗ Found $MISSING_JAVADOC Solution files without Javadoc${NC}"
    ((ERRORS++))
else
    echo -e "${GREEN}✓ All Solution files have Javadoc comments${NC}"
fi
echo ""

# ============ Step 5: Validate test files ============
echo "[5/6] Validating test files..."
SOLUTION_COUNT=$(find java/problems -name "Solution.java" -type f | wc -l)
TEST_COUNT=$(find java/problems -name "*Test.java" -type f | wc -l)

if [ "$SOLUTION_COUNT" -ne "$TEST_COUNT" ]; then
    echo -e "${YELLOW}⚠ Warning: Found $SOLUTION_COUNT solutions but only $TEST_COUNT test files${NC}"
    ((WARNINGS++))
else
    echo -e "${GREEN}✓ All solutions have corresponding test files ($TEST_COUNT)${NC}"
fi
echo ""

# ============ Step 6: Compile and test with Maven ============
echo "[6/6] Compiling and running tests with Maven..."
if command -v mvn &> /dev/null; then
    if cd java && mvn clean test -q 2>/dev/null; then
        echo -e "${GREEN}✓ All tests passed${NC}"
        cd ..
    else
        echo -e "${RED}✗ Maven tests failed${NC}"
        ((ERRORS++))
        cd ..
    fi
else
    echo -e "${YELLOW}⚠ Maven not available, skipping test execution${NC}"
    ((WARNINGS++))
fi
echo ""

# ============ Summary ============
echo "======================================================================"
echo "  📊 Validation Summary"
echo "======================================================================"
echo ""
echo "Solutions Found:        $SOLUTION_COUNT"
echo "Test Files Found:       $TEST_COUNT"
echo "Errors:                 $ERRORS"
echo "Warnings:               $WARNINGS"
echo ""

if [ "$ERRORS" -eq 0 ]; then
    echo -e "${GREEN}✓ Validation Passed!${NC}"
    exit 0
else
    echo -e "${RED}✗ Validation Failed! Please fix the above issues.${NC}"
    exit 1
fi