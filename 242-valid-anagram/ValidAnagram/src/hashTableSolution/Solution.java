package hashTableSolution;
/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: s = "anagram", t = "nagaram", Output: true
Example 2:
Input: s = "rat", t = "car", Output: false
Constraints:
1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.
*/
import java.util.HashMap;
import java.util.Map;


class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        
        for(char x : s.toCharArray()){
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for(char x : t.toCharArray()){
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        for(int val : count.values()){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Example 1:");
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: " + solution.isAnagram(s1, t1));

        // Example 2
        String s2 = "rat";
        String t2 = "car";
        System.out.println("\nExample 2:");
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Output: " + solution.isAnagram(s2, t2));
    }
}