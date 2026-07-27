/**
 * LeetCode 7. Reverse Integer
 *
 * Reverse digits of a 32-bit signed integer.
 * Return 0 if the reversed value overflows.
 *
 * Time:  O(log |x|)
 * Space: O(1)
 */
public class Solution {

    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;   // last digit (works for negative too)
            x /= 10;

            // Check overflow BEFORE actually overflowing
            // Integer.MAX_VALUE =  2147483647
            // Integer.MIN_VALUE = -2147483648
            if (rev > Integer.MAX_VALUE / 10 ||
                (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 ||
                (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }

    // -------------------------------------------------------------------------
    // Test Driver
    // -------------------------------------------------------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.reverse(123));          // 321
        System.out.println(sol.reverse(-123));         // -321
        System.out.println(sol.reverse(120));          // 21
        System.out.println(sol.reverse(0));            // 0
        System.out.println(sol.reverse(1534236469));   // 0 (overflow)
        System.out.println(sol.reverse(-2147483648));  // 0 (overflow)
        System.out.println(sol.reverse(1534236469));   // 0
    }
}