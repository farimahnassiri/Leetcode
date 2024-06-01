/*
* You are given a string s. The score of a string is defined as the sum of the absolute difference 
* between the ASCII values of adjacent characters. Return the score of s.
* 
* Example 1:
* Input: s = "hello", Output: 13
* Explanation: The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. 
* So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.
* Example 2:
* Input: s = "zaz", Output: 50
* Explanation: The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. 
* So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.
* 
* Constraints:
* 2 <= s.length <= 100
* s consists only of lowercase English letters.
*/

class Solution {
    public int scoreOfString(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int a = (int) s.charAt(i);
            int b = (int) s.charAt(i + 1);
            result += differenceInASCII(a, b);
        }
        return result;
    }

    private int differenceInASCII(int a, int b) {
        return Math.abs(a - b);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "hello";
        int result1 = solution.scoreOfString(s1);
        System.out.println("Score of \"" + s1 + "\": " + result1); // Expected output: 13

        // Test case 2
        String s2 = "zaz";
        int result2 = solution.scoreOfString(s2);
        System.out.println("Score of \"" + s2 + "\": " + result2); // Expected output: 50

    }
}
