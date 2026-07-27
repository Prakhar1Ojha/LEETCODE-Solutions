import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * LeetCode 20. Valid Parentheses
 *
 * Check if a string of brackets is valid (correctly matched and ordered).
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class Solution {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        // Map closing bracket → expected opening bracket
        Map<Character, Character> pairs = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );

        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                // Closing bracket
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                // Opening bracket
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isValid("()"));        // true
        System.out.println(sol.isValid("()[]{}"));    // true
        System.out.println(sol.isValid("(]"));        // false
        System.out.println(sol.isValid("([)]"));      // false
        System.out.println(sol.isValid("{[]}"));      // true
        System.out.println(sol.isValid(""));          // true (edge)
        System.out.println(sol.isValid("((("));       // false
        System.out.println(sol.isValid(")))"));       // false
    }
}