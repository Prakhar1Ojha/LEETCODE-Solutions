import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 13. Roman to Integer
 *
 * Convert a Roman numeral string to an integer.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class Solution {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));

            // Look ahead: if current < next → subtractive case
            if (i + 1 < n && value < map.get(s.charAt(i + 1))) {
                total -= value;
            } else {
                total += value;
            }
        }

        return total;
    }

    // -------------------------------------------------------------------------
    // Alternative: Right-to-Left approach
    // -------------------------------------------------------------------------
    public int romanToIntRightToLeft(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50,
            'C', 100, 'D', 500, 'M', 1000
        );

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            if (curr >= prev) {
                total += curr;
            } else {
                total -= curr;
            }
            prev = curr;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.romanToInt("III"));      // 3
        System.out.println(sol.romanToInt("LVIII"));    // 58
        System.out.println(sol.romanToInt("MCMXCIV"));  // 1994
        System.out.println(sol.romanToInt("IX"));       // 9
        System.out.println(sol.romanToInt("XL"));       // 40
        System.out.println(sol.romanToInt("CDXLIV"));   // 444
    }
}