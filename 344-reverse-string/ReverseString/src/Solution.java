/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:

1 <= s.length <= 10^5
s[i] is a printable ascii character.
*/

import java.util.Arrays;

public class Solution {
    public void reverseString(char[] s) {
        int j = s.length - 1;
        char s1, s2;

        for(int i = 0; i < s.length / 2; i++){
            s1 = s[i];
            s2 = s[j];
            s[i] = s2;
            s[j] = s1;
            j--;
        }
    }
    
    public static void main(String[] args) {
        // Test case 1
        char[] s1 = {'h','e','l','l','o'};
        System.out.println("Original string: " + Arrays.toString(s1));
        Solution solution = new Solution();
        solution.reverseString(s1);
        System.out.println("Reversed string: " + Arrays.toString(s1));
        
        // Test case 2
        char[] s2 = {'H','a','n','n','a','h'};
        System.out.println("\nOriginal string: " + Arrays.toString(s2));
        solution.reverseString(s2);
        System.out.println("Reversed string: " + Arrays.toString(s2));
    }
}
