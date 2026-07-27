import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1. Two Sum
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * Approaches included:
 * 1. Brute Force          - O(n²) time, O(1) space
 * 2. HashMap One-Pass     - O(n) time, O(n) space  (Optimal)
 */
public class Solution {

    // -------------------------------------------------------------------------
    // Approach 1: Brute Force
    // Time: O(n²)  |  Space: O(1)
    // -------------------------------------------------------------------------
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // Problem guarantees exactly one solution
        return new int[]{-1, -1};
    }

    // -------------------------------------------------------------------------
    // Approach 2: HashMap One-Pass (Recommended)
    // Time: O(n)  |  Space: O(n)
    // -------------------------------------------------------------------------
    public int[] twoSum(int[] nums, int target) {
        // Map: number → its index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Have we already seen the number that completes the pair?
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store current number and its index for future lookups
            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // should never reach here
    }

    // -------------------------------------------------------------------------
    // Test Driver
    // -------------------------------------------------------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] result1 = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Example 1: [" + result1[0] + ", " + result1[1] + "]"); // [0, 1]

        // Example 2
        int[] result2 = sol.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("Example 2: [" + result2[0] + ", " + result2[1] + "]"); // [1, 2]

        // Example 3
        int[] result3 = sol.twoSum(new int[]{3, 3}, 6);
        System.out.println("Example 3: [" + result3[0] + ", " + result3[1] + "]"); // [0, 1]

        // Extra: negatives
        int[] result4 = sol.twoSum(new int[]{-1, -2, -3, -4, -5}, -8);
        System.out.println("Negatives: [" + result4[0] + ", " + result4[1] + "]"); // [2, 4]
    }
}