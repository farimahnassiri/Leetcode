package DynamicProgramming_1D_Array_Solution;

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
        List<List<Integer>> result = new ArrayList<>();
        
        if (numRows <= 0) {
            return result; // Return an empty list if numRows is non-positive
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            
            // Fill the current row
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentRow.add(1); // First and last elements of each row are always 1
                } else {
                    // Sum of the two elements from the previous row
                    currentRow.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            
            result.add(currentRow); // Add the current row to the result
        }

        return result;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution(); // Create an instance of Solutions class
	    int numRows = 5; // Number of rows for Pascal's triangle
	    List<List<Integer>> triangle = solution.generate(numRows); // Call the generate method
	    printTriangle(triangle); // Print the generated Pascal's triangle
	}
	
    // Helper method to print Pascal's triangle
    private static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
