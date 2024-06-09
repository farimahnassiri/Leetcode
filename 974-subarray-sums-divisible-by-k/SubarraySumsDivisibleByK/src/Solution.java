/*
* Given an integer array nums and an integer k, return the number of non-empty
* subarrays that have a sum divisible by k. A subarray is a contiguous part of an array.
* Example 1:
* Input: nums = [4,5,0,-2,-3,1], k = 5
* Output: 7
* Explanation: There are 7 subarrays with a sum divisible by k = 5:
* [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
* Example 2:
* Input: nums = [5], k = 9
* Output: 0
* Constraints:
* 1 <= nums.length <= 3 * 10^4
* -10^4 <= nums[i] <= 10^4
* 2 <= k <= 10^4
*/

import java.util.*;

import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        
        for (int num : nums) {
            prefixSum += num;
            int mod = prefixSum % k;
            
            if (mod < 0) {
                mod += k;
            }

            if (prefixMap.containsKey(mod)) {
                count += prefixMap.get(mod);
                prefixMap.put(mod, prefixMap.get(mod) + 1);
            } else {
                prefixMap.put(mod, 1);
            }
        }
        return count;
    }

    // Modified printTest method
    public void printTest(int[] nums, int k) {
        int result = subarraysDivByK(nums, k);
        System.out.println("Input: nums = " + arrayToString(nums) + ", k = " + k);
        System.out.println("Output: " + result);
    }

    // Helper method to convert an array to a string for printing
    private String arrayToString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test cases
        solution.printTest(new int[]{4, 5, 0, -2, -3, 1}, 5); // Expected output: 7
        solution.printTest(new int[]{5}, 9); // Expected output: 0
        // Add more test cases as needed
    }
}
