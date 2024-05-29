/*
* Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 
* under the following rules:
* If the current number is even, you have to divide it by 2.
* If the current number is odd, you have to add 1 to it.
* It is guaranteed that you can always reach one for all test cases.
* Example 1:
* Input: s = "1101", Output: 6
* Explanation: "1101" corresponds to number 13 in their decimal representation.
* Step 1) 13 is odd, add 1 and obtain 14. 
* Step 2) 14 is even, divide by 2 and obtain 7.
* Step 3) 7 is odd, add 1 and obtain 8.
* Step 4) 8 is even, divide by 2 and obtain 4.  
* Step 5) 4 is even, divide by 2 and obtain 2. 
* Step 6) 2 is even, divide by 2 and obtain 1. 
* Example 2:
* Input: s = "10", Output: 1
* Explanation: "10" corresponds to number 2 in their decimal representation.
* Step 1) 2 is even, divide by 2 and obtain 1. 
* Example 3:
* Input: s = "1", Output: 0
* Constraints:
* 1 <= s.length <= 500
* s consists of characters '0' or '1'
* s[0] == '1'
*/

class Solution {
	
    private int binaryNum(String s) {
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(length - 1 - i) == '1') {
                result += Math.pow(2, i);
            }
        }
        return result;
    }

    public int numSteps(String s) {
        int number = binaryNum(s);
        int steps = 0;
        
        while (number > 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number += 1;
            }
            steps++;
        }
        return steps;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String s1 = "1101";
        System.out.println("Example 1: " + sol.numSteps(s1)); // Expected output: 6

        // Example 2
        String s2 = "10";
        System.out.println("Example 2: " + sol.numSteps(s2)); // Expected output: 1

        // Example 3
        String s3 = "1";
        System.out.println("Example 3: " + sol.numSteps(s3)); // Expected output: 0
    }
    
}