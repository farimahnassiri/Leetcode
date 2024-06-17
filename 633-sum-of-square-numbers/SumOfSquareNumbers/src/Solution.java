/*
 * Given a non-negative integer c, decide whether there're two integers 
 * a and b such that a^2 + b^2 = c.
 * Example 1:
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * Input: c = 3
 * Output: false
 * Constraints:
 * 0 <= c <= (2^31) - 1
 */

class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while(left <= right){
            if(left * left + right * right == c){
                return true;
            }
            else if(left * left + right * right > c){
                right--;
            }
            else{
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    	Solution sl = new Solution();
        // Test cases
        int[] testCases = {5, 3}; // Add more test cases as needed
        for (int testCase : testCases) {
            System.out.println("Input: " + testCase);
            System.out.println("Output: " + sl.judgeSquareSum(testCase));
            System.out.println();
        }
    }
}
