/*
 * Given an integer array nums of unique elements, return all possible
 * subsets (the power set). The solution set must not contain duplicate subsets. 
 * Return the solution in any order.
 * Example 1:
 * Input: nums = [1,2,3], Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * Input: nums = [0], Output: [[],[0]]
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        
        // Step 1: Initialize the result list
        List<List<Integer>> ans = new ArrayList<>();
        
        // Step 2: Iterate over all possible subsets
        for (int i = 0; i < (1 << n); i++) {
            // Step 3: Create each subset
            List<Integer> temp = new ArrayList<>();
            
            // Step 4: Determine elements in each subset
            for (int j = 0; j < n; j++) {
                // Step 5: Check if element should be included
                if (checkBit(i, j)) {
                    temp.add(nums[j]);
                }
            }
            
            // Step 6: Add subset to result list
            ans.add(temp);
        }
        
        return ans;
    }
    
    // Step 7: Helper method to check bits
    boolean checkBit(int n, int i) {
        return ((n >> i) & 1) == 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(sol.subsets(nums));
    }
    
}