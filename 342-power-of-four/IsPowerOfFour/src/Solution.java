/*
* Given an integer n, return true if it is a power of four, otherwise, return false.
* An integer n is a power of four if there exists an integer x such that n == 4x.
*
* Example 1:
* Input: n = 16, Output: true
*
* Example 2:
* Input: n = 5, Output: false
*
* Example 3:
* Input: n = 1, Output: true
*
* Constraints: -231 <= n <= 231 - 1
*
* Follow up: Could you solve it without loops/recursion?
*/

public class Solution {
	
	public boolean isPowerOfFour(int n) {
		if (n == 0){
			return false;
	    }
	    if (n == 1){
	        return true;
	    }
	    if(n % 4 == 0){
	        return isPowerOfFour(n/4);
	    }
	    return false;
	}

	
	public static void main(String[] args) {
		Solution tester = new Solution();
	  
		System.out.println("Example 1: " + tester.isPowerOfFour(16)); // Output: true
	    System.out.println("Example 2: " + tester.isPowerOfFour(5));  // Output: false
	    System.out.println("Example 3: " + tester.isPowerOfFour(1));  // Output: true 
	}

}
