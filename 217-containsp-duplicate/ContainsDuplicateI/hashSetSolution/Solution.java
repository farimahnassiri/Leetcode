/*
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
package hashSetSolution;

import java.util.*;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
    	HashSet<Integer> seen = new HashSet<>();
    	for(int num: nums) {
    		if(seen.contains(num)) {
    			return true;
    		}
    		seen.add(num);
    	}
    	return false;
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sl = new Solution();
        // Example 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Example 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + sl.containsDuplicate(nums1));

        // Example 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("\nExample 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + sl.containsDuplicate(nums2));

        // Example 3
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("\nExample 3:");
        System.out.println("Input: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + sl.containsDuplicate(nums3));
    }

}
