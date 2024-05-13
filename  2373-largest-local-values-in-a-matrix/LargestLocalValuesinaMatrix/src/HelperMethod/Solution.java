package HelperMethod;

/*
 * You are given an n x n integer matrix grid.
 * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
 * * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
 * In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
 * Return the generated matrix.
 *
 * Example 1:
 * Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]], Output: [[9,9],[8,6]]
 * Explanation: The diagram above shows the original matrix and the generated matrix.
 * Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.
 * Example 2:
 * Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]], Output: [[2,2,2],[2,2,2],[2,2,2]]
 * Explanation: Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.
 *
 * Constraints:
 * * n == grid.length == grid[i].length
 * * 3 <= n <= 100
 * * 1 <= grid[i][j] <= 100
 */


class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int[][] ans = new int[n - 2][n - 2];

        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < n - 2; j++) {
                ans[i][j] = findMax(i, j, grid);
            }
        }
        return ans;   
    }

    public int findMax(int r, int c, int[][] grid) {
        int max = Integer.MIN_VALUE;

        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) max = Math.max(max, grid[i][j]);
        }
        return max;
    }
    public static void main(String[] args) {
    	Solution sl1 = new Solution();
    	Solution sl2 = new Solution();
    	
        int[][] grid1 = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] result1 = sl1.largestLocal(grid1);
        System.out.println("Example 1 Output:");
        printMatrix(result1);

        int[][] grid2 = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int[][] result2 = sl2.largestLocal(grid2);
        System.out.println("\nExample 2 Output:");
        printMatrix(result2);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}