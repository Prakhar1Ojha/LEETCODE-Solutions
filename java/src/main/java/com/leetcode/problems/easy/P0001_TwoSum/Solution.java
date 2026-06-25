package com.leetcode.problems.easy;

import java.util.*;
import java.util.Objects;

/**
 * LeetCode Problem #1: Two Sum
 * 
 * Problem:
 * Given an array of integers nums and an integer target, return the indices of the two numbers
 * that add up to target. You may assume that each input has exactly one solution, and you may
 * not use the same element twice.
 * 
 * Approach:
 * Use a HashMap to store each number and its index as we iterate through the array. For each
 * number, check if its complement (target - num) exists in the map. If it does, we've found
 * our pair. If not, add the current number to the map and continue.
 * 
 * Why HashMap?
 * - HashMap provides O(1) average-case lookup, enabling us to achieve O(n) time complexity
 * - Alternative brute force (nested loops) would be O(n²), which is inefficient
 * - Trade-off: We use O(n) extra space for the HashMap to achieve O(n) time
 * 
 * Time Complexity: O(n) - Single pass through array, O(1) HashMap operations
 * Space Complexity: O(n) - HashMap stores at most n-1 elements
 * 
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 9, so we return [0, 1].
 */
public class Solution {
    
    /**
     * Finds two distinct indices in the array whose values sum to the target.
     * 
     * @param nums array of integers (1 <= nums.length <= 10^4)
     * @param target the target sum (-10^9 <= target <= 10^9)
     * @return array of two indices [i, j] where nums[i] + nums[j] == target and i != j
     * @throws IllegalArgumentException if array has less than 2 elements or no solution exists
     * @throws NullPointerException if nums is null
     */
    public int[] twoSum(int[] nums, int target) {
        Objects.requireNonNull(nums, "nums array cannot be null");
        
        if (nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        
        // HashMap to store value -> index mapping
        // We'll use this to check if complement exists in O(1) time
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if we've seen the complement before
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            
            // Store current number and its index for future lookups
            numMap.put(nums[i], i);
        }
        
        // No solution found
        throw new IllegalArgumentException("No two sum solution found for target: " + target);
    }
    
    /**
     * Main method for interactive testing.
     * Allows users to input an array and target, then displays the solution indices.
     * 
     * Example usage:
     * Enter array size: 4
     * Enter array elements:
     * 2
     * 7
     * 11
     * 15
     * Enter target sum: 9
     * Indices: [0, 1]
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter array size: ");
            int n = scanner.nextInt();
            
            // Validate array size
            if (n < 2) {
                System.out.println("Array must have at least 2 elements");
                return;
            }
            
            // Read array elements
            int[] nums = new int[n];
            System.out.println("Enter array elements:");
            for (int i = 0; i < n; i++) {
                if (scanner.hasNextInt()) {
                    nums[i] = scanner.nextInt();
                } else {
                    System.err.println("Invalid input: expected integer");
                    return;
                }
            }
            
            // Read target
            System.out.print("Enter target sum: ");
            if (!scanner.hasNextInt()) {
                System.err.println("Invalid input: expected integer");
                return;
            }
            int target = scanner.nextInt();
            
            // Solve and display result
            Solution solution = new Solution();
            int[] result = solution.twoSum(nums, target);
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println("Error: Unexpected end of input");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
