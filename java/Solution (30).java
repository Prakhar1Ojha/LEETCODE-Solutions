/**
 * LeetCode 35. Search Insert Position
 *
 * Find the index where target is or should be inserted in a sorted array.
 * Must be O(log n).
 *
 * Time:  O(log n)
 * Space: O(1)
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // left is the insertion point
        return left;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 2)); // 1
        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 7)); // 4
        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 0)); // 0
        System.out.println(sol.searchInsert(new int[]{1}, 0));          // 0
    }
}