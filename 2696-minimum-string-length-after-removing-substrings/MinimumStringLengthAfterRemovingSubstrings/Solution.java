/*
 * You are given a string s consisting only of uppercase English letters.
 * You can apply some operations to this string where, in one operation,
 * you can remove any occurrence of one of the substrings "AB" or "CD" from s.
 * Return the minimum possible length of the resulting string that you can obtain.
 * Note that the string concatenates after removing the substring and 
 * could produce new "AB" or "CD" substrings.
 *  
 * Example 1:
 * Input: s = "ABFCACDB"
 * Output: 2
 * Explanation: We can do the following operations:
 * - Remove the substring "ABFCACDB", so s = "FCACDB".
 * - Remove the substring "FCACDB", so s = "FCAB".
 * - Remove the substring "FCAB", so s = "FC".
 * So the resulting length of the string is 2.
 * It can be shown that it is the minimum length that we can obtain.
 * 
 * Example 2:
 * Input: s = "ACBBD"
 * Output: 5
 * Explanation: We cannot do any operations on the string so the length remains the same.
 *  
 * Constraints:
 * 1 <= s.length <= 100
 * s consists only of uppercase English letters.
 */
import java.util.*;
public class Solution {
	public int minLength(String s) {
		Stack<Character> stack = new Stack<>();
	    	
		for(int i = 0; i < s.length(); i++){
			char current_char = s.charAt(i);
			if(stack.isEmpty()){
				stack.push(current_char);
	            continue;
	        }
	        if(current_char == 'B' && stack.peek() == 'A'){
	        	stack.pop();
	        }
	        else if(current_char == 'D' && stack.peek() == 'C'){
	        	stack.pop();
	        }
	        else{
	            stack.push(current_char);
	        }
	    }
		return stack.size();
	}
    public static void main(String[] args) {
    	Solution sl = new Solution();
        // Example 1
        String s1 = "ABFCACDB";
        int result1 = sl.minLength(s1);
        System.out.println("Output for s = \"" + s1 + "\": " + result1);  // Expected output: 2

        // Example 2
        String s2 = "ACBBD";
        int result2 = sl.minLength(s2);
        System.out.println("Output for s = \"" + s2 + "\": " + result2);  // Expected output: 5
    }
	
}
