/**
 * LeetCode 9. Palindrome Number
 *
 * Determine whether an integer is a palindrome.
 * Solve without converting the integer to a string.
 *
 * Time:  O(log x)
 * Space: O(1)
 */
public class Solution {

    public boolean isPalindrome(int x) {
        // Negatives are not palindromes
        // Numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // Reverse the second half of the digits
        // Stop when reversedHalf >= remaining x
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even number of digits: x == reversedHalf
        // For odd number of digits:  x == reversedHalf / 10  (middle digit ignored)
        return x == reversedHalf || x == reversedHalf / 10;
    }

    // -------------------------------------------------------------------------
    // Alternative: Full reverse (with long to avoid overflow)
    // -------------------------------------------------------------------------
    public boolean isPalindromeFullReverse(int x) {
        if (x < 0) return false;

        long original = x;
        long rev = 0;

        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return original == rev;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isPalindrome(121));    // true
        System.out.println(sol.isPalindrome(-121));   // false
        System.out.println(sol.isPalindrome(10));     // false
        System.out.println(sol.isPalindrome(0));      // true
        System.out.println(sol.isPalindrome(12321));  // true
        System.out.println(sol.isPalindrome(123321)); // true
        System.out.println(sol.isPalindrome(1001));   // true
    }
}