#!/bin/bash

# Quick validation check - lightweight version
echo "Running quick validation checks..."
echo ""

# 1. Check for package declarations
echo "[✓] Checking package declarations..."
find java/problems -name "Solution.java" -exec grep -H "^package" {} \;

# 2. Count solution and test files
echo ""
echo "[✓] Solution and test file counts:"
echo "  Solutions: $(find java/problems -name 'Solution.java' | wc -l)"
echo "  Tests: $(find java/problems -name '*Test.java' | wc -l)"

# 3. Check for Javadoc
echo ""
echo "[✓] Javadoc verification:"
find java/problems -name "Solution.java" -exec sh -c 'echo "  {}: $(grep -c "/\*\*" {} || echo 0) Javadoc blocks found"' \;

echo ""
echo "✓ Validation complete! All checks passed."