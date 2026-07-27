/**
 * LeetCode 26. Remove Duplicates from Sorted Array
 *
 * Remove duplicates in-place from a sorted array.
 * Return the count of unique elements.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1; // next position to write a unique value

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 1, 2};
        int k1 = sol.removeDuplicates(nums1);
        System.out.print("k = " + k1 + ", nums = [");
        for (int i = 0; i < k1; i++) System.out.print(nums1[i] + (i < k1 - 1 ? "," : ""));
        System.out.println("]"); // k = 2, nums = [1,2]

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = sol.removeDuplicates(nums2);
        System.out.print("k = " + k2 + ", nums = [");
        for (int i = 0; i < k2; i++) System.out.print(nums2[i] + (i < k2 - 1 ? "," : ""));
        System.out.println("]"); // k = 5, nums = [0,1,2,3,4]
    }
}