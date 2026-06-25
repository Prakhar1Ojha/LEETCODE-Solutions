import java.util.*;

public class TwoSum {
    
    /**
     * Finds two indices in the array that sum to the target.
     * Uses a HashMap for optimal O(n) time complexity.
     * 
     * @param nums the input array of integers
     * @param target the target sum
     * @return array of two indices [i, j] where nums[i] + nums[j] == target
     * @throws IllegalArgumentException if array has less than 2 elements
     */
    public int[] twoSum(int[] nums, int target) {
        // Input validation
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        
        // Use HashMap to store value -> index mapping
        // Time Complexity: O(n), Space Complexity: O(n)
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // Store current number and its index
            map.put(nums[i], i);
        }
        
        // No solution found
        return new int[]{};
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of array: ");
            int n = sc.nextInt();
            
            // Validate array size
            if (n < 2) {
                System.out.println("Array must have at least 2 elements");
                return;
            }
            
            int[] nums = new int[n];
            System.out.println("Enter array elements:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            
            System.out.print("Enter target: ");
            int target = sc.nextInt();
            
            TwoSum obj = new TwoSum();
            int[] result = obj.twoSum(nums, target);
            
            if (result.length == 2) {
                System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
            } else {
                System.out.println("No solution found");
            }
        }
    }
}
