/**
 * LeetCode 27. Remove Element
 *
 * Remove all occurrences of val in-place and return the new length.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int k = 0; // next position for a kept element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    // Alternative: swap with end (fewer writes when many removals)
    public int removeElementSwap(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 2, 2, 3};
        int k1 = sol.removeElement(nums1, 3);
        System.out.print("k = " + k1 + " → [");
        for (int i = 0; i < k1; i++) System.out.print(nums1[i] + (i < k1 - 1 ? "," : ""));
        System.out.println("]"); // 2 → [2,2]

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int k2 = sol.removeElement(nums2, 2);
        System.out.print("k = " + k2 + " → [");
        for (int i = 0; i < k2; i++) System.out.print(nums2[i] + (i < k2 - 1 ? "," : ""));
        System.out.println("]"); // 5 → [0,1,3,0,4]
    }
}