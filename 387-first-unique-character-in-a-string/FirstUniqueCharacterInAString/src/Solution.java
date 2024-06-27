/*
* Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
* Example 1:
* Input: s = "leetcode"
* Output: 0
* Example 2:
* Input: s = "loveleetcode"
* Output: 2
* Example 3:
* Input: s = "aabb"
* Output: -1
* Constraints:
* 1 <= s.length <= 10^5
* s consists of only lowercase English letters.
*/
import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
    	Solution s1 = new Solution();
        // Test cases
        String testCase1 = "leetcode";
        String testCase2 = "loveleetcode";
        String testCase3 = "aabb";

        // Run the method and print the results
        System.out.println("Index of first unique character in \"" + testCase1 + "\": " + s1.firstUniqChar(testCase1));
        System.out.println("Index of first unique character in \"" + testCase2 + "\": " + s1.firstUniqChar(testCase2));
        System.out.println("Index of first unique character in \"" + testCase3 + "\": " + s1.firstUniqChar(testCase3));
    }
}
