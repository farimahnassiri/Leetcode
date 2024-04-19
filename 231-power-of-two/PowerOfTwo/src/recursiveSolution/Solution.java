package recursiveSolution;
/*
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * 
 * An integer n is a power of two, if there exists an integer x such that n == 2^x.
 *
 * Example 1:
 * Input: n = 1, Output: true
 * Explanation: 2^0 = 1
 *
 * Example 2:
 * Input: n = 16, Output: true
 * Explanation: 2^4 = 16
 *
 * Example 3:
 * Input: n = 3, Output: false
 * 
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1){
            return true;
        }
        if (n == 0 || n % 2 == 1){
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isPowerOfTwo(1)); // true
        System.out.println(solution.isPowerOfTwo(16)); // true
        System.out.println(solution.isPowerOfTwo(3)); // false
    }
}