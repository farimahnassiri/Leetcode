/*
* You are given two strings s and t of the same length and an integer maxCost.
* You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| 
* (i.e., the absolute difference between the ASCII values of the characters).
* Return the maximum length of a substring of s that can be changed to be the same as the corresponding 
* substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be 
* changed to its corresponding substring from t, return 0.
* Example 1:
* Input: s = "abcd", t = "bcdf", maxCost = 3, Output: 3
* Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum length is 3.
* Example 2:
* Input: s = "abcd", t = "cdef", maxCost = 3, Output: 1
* Explanation: Each character in s costs 2 to change to character in t, so the maximum length is 1.
* Example 3:
* Input: s = "abcd", t = "acde", maxCost = 0, Output: 1
* Explanation: You cannot make any change, so the maximum length is 1.
* Constraints:
* 1 <= s.length <= 10^5
* t.length == s.length
* 0 <= maxCost <= 10^6
* s and t consist of only lowercase English letters.
*/

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int diff[] = new int[s.length()];
        for(int i = 0;i<s.length();i++) diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        int start = 0;
        int count = 0;
        for(int i = 0;i<s.length();i++){
            maxCost -= diff[i];
            while(maxCost < 0){
                maxCost += diff[start++];
            }
            count = Math.max(count, i - start + 1);
        }
        return count;
    }
    public static void main(String[] args) {
    	Solution sol1 = new Solution();
    	Solution sol2 = new Solution();
    	Solution sol3 = new Solution();
        // Example 1
        String s1 = "abcd";
        String t1 = "bcdf";
        int maxCost1 = 3;
        int result1 = sol1.equalSubstring(s1, t1, maxCost1);
        printExampleResult(1, s1, t1, maxCost1, result1);
        
        // Example 2
        String s2 = "abcd";
        String t2 = "cdef";
        int maxCost2 = 3;
        int result2 = sol2.equalSubstring(s2, t2, maxCost2);
        printExampleResult(2, s2, t2, maxCost2, result2);
        
        // Example 3
        String s3 = "abcd";
        String t3 = "acde";
        int maxCost3 = 0;
        int result3 = sol3.equalSubstring(s3, t3, maxCost3);
        printExampleResult(3, s3, t3, maxCost3, result3);
    }

    public static void printExampleResult(int exampleNum, String s, String t, int maxCost, int result) {
        System.out.println("Example " + exampleNum + ":");
        System.out.println("Input: s = \"" + s + "\", t = \"" + t + "\", maxCost = " + maxCost);
        System.out.println("Output: " + result);
        System.out.println();
    }

    
}