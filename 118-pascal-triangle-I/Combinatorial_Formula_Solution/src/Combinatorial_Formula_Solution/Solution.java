package Combinatorial_Formula_Solution;

/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * Example 1:
 * 		Input: numRows = 5, Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * 		Input: numRows = 1, Output: [[1]]
 * 
 * Constraints: (1 <= numRows <= 30)
 **/

import java.util.ArrayList;
import java.util.List;

public class Solution {
	 public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> triangle = new ArrayList<>();
	        
	        for (int i = 0; i < numRows; i++) {
	            List<Integer> currentRow = new ArrayList<>();
	            for (int j = 0; j <= i; j++) {
	                currentRow.add(binomialCoefficient(i, j));
	            }
	            triangle.add(currentRow);
	        }
	        
	        return triangle;
	    }
	    
	    private int binomialCoefficient(int n, int k) {
	        return factorial(n) / (factorial(k) * factorial(n - k));
	    }
	    
	    private int factorial(int n) {
	        if (n == 0 || n == 1) {
	            return 1;
	        }
	        int result = 1;
	        for (int i = 2; i <= n; i++) {
	            result *= i;
	        }
	        return result;
	    }
	    
		public static void main(String[] args) {
			Solution solution = new Solution();
		    int numRows = 5;
		    List<List<Integer>> triangle = solution.generate(numRows);
		    TrianglePrinter.printTriangle(triangle);
		}

}
