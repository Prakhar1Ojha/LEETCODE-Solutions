import java.util.*;

class Solution {

    /**
     * Checks whether a given integer is a palindrome.
     *
     * A palindrome number reads the same from left to right
     * and from right to left.
     *
     * Approach:
     * Reverse only the second half of the number instead of
     * reversing the entire number. This avoids integer overflow
     * and uses constant extra space.
     *
     * Time Complexity: O(log10(n))
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(int x) {

        // Negative numbers can never be palindromes
        // because of the '-' sign.
        if (x < 0) {
            return false;
        }

        // Numbers ending with 0 (except 0 itself)
        // cannot be palindromes.
        // Example:
        // 10 -> 01 (not equal)
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        // Stores the reversed second half of the number.
        int reversedHalf = 0;

        // Reverse digits until the reversed half
        // becomes greater than or equal to
        // the remaining original half.
        while (x > reversedHalf) {

            // Extract the last digit.
            int lastDigit = x % 10;

            // Append the digit to reversedHalf.
            reversedHalf = reversedHalf * 10 + lastDigit;

            // Remove the last digit from x.
            x /= 10;
        }

        /*
         * Two possible cases:
         *
         * 1. Even number of digits
         *    Example:
         *    1221
         *
         *    x = 12
         *    reversedHalf = 12
         *
         *    Compare:
         *    x == reversedHalf
         *
         *
         * 2. Odd number of digits
         *    Example:
         *    12321
         *
         *    x = 12
         *    reversedHalf = 123
         *
         *    Ignore the middle digit by dividing
         *    reversedHalf by 10.
         *
         *    Compare:
         *    x == reversedHalf / 10
         */

        return x == reversedHalf || x == reversedHalf / 10;
    }
}
