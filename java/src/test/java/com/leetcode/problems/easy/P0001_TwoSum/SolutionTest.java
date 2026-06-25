package com.leetcode.problems.easy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for LeetCode Problem #1: Two Sum
 * 
 * Tests cover:
 * - Basic examples from problem statement
 * - Edge cases (empty, single element, duplicates)
 * - Invalid inputs (null, insufficient size)
 * - Large inputs for performance verification
 * - Negative numbers and zero
 */
public class SolutionTest {
    
    private Solution solution;
    
    @Before
    public void setUp() {
        solution = new Solution();
    }
    
    // ========== BASIC TEST CASES ==========
    
    /**
     * Test the primary example from LeetCode problem statement.
     * Input: [2,7,11,15], target: 9
     * Expected: [0,1] (indices, not values)
     */
    @Test
    public void testBasicExample() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        
        // Verify we got 2 indices
        assertEquals("Result should contain 2 indices", 2, result.length);
        
        // Verify the indices are correct
        assertTrue("Indices should be 0 and 1",
                (result[0] == 0 && result[1] == 1) || (result[0] == 1 && result[1] == 0));
        
        // Verify the sum
        assertEquals("Sum should equal target", target, nums[result[0]] + nums[result[1]]);
    }
    
    /**
     * Test with negative numbers.
     */
    @Test
    public void testNegativeNumbers() {
        int[] nums = {-1, -2, -3, 5, 10};
        int target = 7;
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    /**
     * Test with zero as one of the elements.
     */
    @Test
    public void testWithZero() {
        int[] nums = {0, 0, 3, 4};
        int target = 0;
        int[] result = solution.twoSum(nums, target);
        
        assertEquals("Two zeros should sum to zero", target, nums[result[0]] + nums[result[1]]);
    }
    
    /**
     * Test minimum array size (exactly 2 elements).
     */
    @Test
    public void testMinimumArraySize() {
        int[] nums = {1, 2};
        int target = 3;
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(2, result.length);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    // ========== EDGE CASES ==========
    
    /**
     * Test with large positive numbers.
     */
    @Test
    public void testLargePositiveNumbers() {
        int[] nums = {1000000000, 999999999, 1};
        int target = 1999999999;
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    /**
     * Test with large negative numbers.
     */
    @Test
    public void testLargeNegativeNumbers() {
        int[] nums = {-1000000000, -999999999, -1};
        int target = -1999999999;
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    /**
     * Test with duplicate numbers in array.
     */
    @Test
    public void testDuplicateNumbers() {
        int[] nums = {3, 3, 4};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        
        // Should use two different indices
        assertNotEquals("Indices should be different", result[0], result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    /**
     * Test when solution is at the very end of array.
     */
    @Test
    public void testSolutionAtEnd() {
        int[] nums = {5, 6, 7, 8, 9, 10};
        int target = 19;  // 9 + 10
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    /**
     * Test when solution is at the beginning of array.
     */
    @Test
    public void testSolutionAtBeginning() {
        int[] nums = {1, 2, 100, 200};
        int target = 3;  // 1 + 2
        int[] result = solution.twoSum(nums, target);
        
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
    
    // ========== PERFORMANCE TEST ==========
    
    /**
     * Test with larger array for performance verification.
     * Should complete within reasonable time O(n) rather than O(n²).
     */
    @Test
    public void testLargeInput() {
        int size = 10000;
        int[] nums = new int[size];
        
        // Create array: 0, 1, 2, ..., size-1
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }
        
        int target = size - 1 + size - 2;  // sum of last two elements
        
        long startTime = System.currentTimeMillis();
        int[] result = solution.twoSum(nums, target);
        long duration = System.currentTimeMillis() - startTime;
        
        assertEquals(target, nums[result[0]] + nums[result[1]]);
        
        // O(n) algorithm should complete in less than 100ms for size 10000
        assertTrue("Performance: should complete in < 100ms, took " + duration + "ms",
                duration < 100);
    }
    
    // ========== INVALID INPUT TESTS ==========
    
    /**
     * Test with null input array.
     */
    @Test(expected = NullPointerException.class)
    public void testNullArray() {
        solution.twoSum(null, 5);
    }
    
    /**
     * Test with array containing only 1 element.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testArrayTooSmall() {
        solution.twoSum(new int[]{5}, 5);
    }
    
    /**
     * Test with empty array.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArray() {
        solution.twoSum(new int[]{}, 5);
    }
    
    /**
     * Test when no solution exists.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNoSolution() {
        int[] nums = {1, 2, 3};
        int target = 10;  // No two elements sum to 10
        solution.twoSum(nums, target);
    }
    
    /**
     * Test when target is unreachable with given array.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTargetTooLarge() {
        int[] nums = {1, 2, 3};
        int target = 1000000000;  // Unreachable
        solution.twoSum(nums, target);
    }
    
    // ========== VERIFICATION TESTS ==========
    
    /**
     * Verify that indices are different (problem requires different elements).
     */
    @Test
    public void testIndicesMustBeDifferent() {
        int[] nums = {1, 1, 2};
        int target = 2;
        int[] result = solution.twoSum(nums, target);
        
        assertNotEquals("Indices must be different", result[0], result[1]);
    }
    
    /**
     * Verify that returned indices are valid (within array bounds).
     */
    @Test
    public void testIndicesAreValid() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        
        assertTrue("Index 0 should be valid", result[0] >= 0 && result[0] < nums.length);
        assertTrue("Index 1 should be valid", result[1] >= 0 && result[1] < nums.length);
    }
}
