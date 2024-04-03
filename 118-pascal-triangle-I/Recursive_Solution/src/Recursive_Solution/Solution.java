package Recursive_Solution;

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
        generateHelper(numRows, triangle);
        return triangle;
    }

    private void generateHelper(int numRows, List<List<Integer>> triangle) {
        if (numRows <= 0) {
            return;
        }

        generateHelper(numRows - 1, triangle); // Recursively generate the previous row

        List<Integer> currentRow = new ArrayList<>();
        
        currentRow.add(1); // First element is always 1

        List<Integer> prevRow = triangle.isEmpty() ? null : triangle.get(triangle.size() - 1);
        if (prevRow != null) {
            for (int i = 1; i < prevRow.size(); i++) {
                currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
            }
            currentRow.add(1); // Last element is always 1
        }

        triangle.add(currentRow);
    }
    
	public static void main(String[] args) {
		Solution solution = new Solution();
	    int numRows = 5; // Number of rows for Pascal's triangle
	    List<List<Integer>> triangle = solution.generate(numRows);
   
	    TrianglePrinter.printTriangle(triangle);
	}

}