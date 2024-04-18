/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * Example 1:
 * Input: s = "aba", Output: true
 *
 * Example 2:
 * Input: s = "abca", Output: true
 * Explanation: You could delete the character 'c'.
 *
 * Example 3:
 * Input: s = "abc", Output: false
 *
 * Constraints:
 *  - 1 <= s.length <= 10^5
 *  - s consists of lowercase English letters.
 */

class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left + 1, right)) {
                    return true;
                }
                if (isPalindrome(s, left, right - 1)) {
                    return true;
                }
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.validPalindrome("aba")); // true
        System.out.println(solution.validPalindrome("abca")); // true
        System.out.println(solution.validPalindrome("abc")); // false
    }
}