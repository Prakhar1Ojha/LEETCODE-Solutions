/**
 * LeetCode 977. Squares of a Sorted Array
 *
 * Return the squares of a sorted array, also sorted.
 *
 * Optimal: Two pointers – O(n) time
 */
public class Solution {

    // Optimal two-pointer approach
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int pos = n - 1; // fill from the end

        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                result[pos] = leftSq;
                left++;
            } else {
                result[pos] = rightSq;
                right--;
            }
            pos--;
        }

        return result;
    }

    // Simple approach for comparison
    public int[] sortedSquaresSimple(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i] * nums[i];
        }
        java.util.Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] r1 = sol.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.print("[");
        for (int i = 0; i < r1.length; i++) System.out.print(r1[i] + (i < r1.length - 1 ? "," : ""));
        System.out.println("]"); // [0,1,9,16,100]

        int[] r2 = sol.sortedSquares(new int[]{-7, -3, 2, 3, 11});
        System.out.print("[");
        for (int i = 0; i < r2.length; i++) System.out.print(r2[i] + (i < r2.length - 1 ? "," : ""));
        System.out.println("]"); // [4,9,9,49,121]
    }
}