/*
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

Example 1:
Input: n = 3, Output: 5

Example 2:
Input: n = 1, Output: 1

Constraints:
1 <= n <= 19
*/

public class Solution {
    public int numTrees(int n) {
        int[] arr = new int[n + 1];

        if(n < 2){
            return 1;
        }
        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i<= n; i++){
            int answer = 0, f = 0, s = i - 1;
                for(int j = 1; j <= i; j++){
                    answer = answer + (arr[f] * arr[s]);
                    f++;
                    s--;
                }
                arr[i] = answer;
        }
        return arr[n];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Example 1
        int n1 = 3;
        System.out.println("Example 1:");
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + solution.numTrees(n1));
        
        // Test Example 2
        int n2 = 1;
        System.out.println("\nExample 2:");
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + solution.numTrees(n2));
    }
}
