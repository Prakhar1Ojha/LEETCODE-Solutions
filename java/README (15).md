/**
 * LeetCode 14. Longest Common Prefix
 *
 * Find the longest common prefix string amongst an array of strings.
 *
 * Time:  O(S)  where S = total number of characters
 * Space: O(1)
 */
public class Solution {

    // Horizontal scanning
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Keep shortening prefix until the current string starts with it
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    // Vertical scanning (often cleaner)
    public String longestCommonPrefixVertical(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int col = 0; col < strs[0].length(); col++) {
            char c = strs[0].charAt(col);

            for (int row = 1; row < strs.length; row++) {
                // If any string is shorter or character mismatches
                if (col >= strs[row].length() || strs[row].charAt(col) != c) {
                    return strs[0].substring(0, col);
                }
            }
        }

        return strs[0]; // entire first string is the prefix
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.longestCommonPrefix(
            new String[]{"flower", "flow", "flight"}));          // "fl"

        System.out.println(sol.longestCommonPrefix(
            new String[]{"dog", "racecar", "car"}));             // ""

        System.out.println(sol.longestCommonPrefix(
            new String[]{"interspecies", "interstellar", "interstate"})); // "inters"

        System.out.println(sol.longestCommonPrefix(
            new String[]{"a"}));                                 // "a"

        System.out.println(sol.longestCommonPrefix(
            new String[]{"", "b"}));                             // ""
    }
}