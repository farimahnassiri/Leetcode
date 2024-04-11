/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * Example 1:
 * Input: nums = [3,2,3], Output: 3
 * 
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2], Output: 2
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {
        // majority when num appears more that half the size of array
        int lengthArr = nums.length - 1;
        if (lengthArr == 0){
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[lengthArr/2];
    }
	public static void main(String[] args) {
		Solution sl = new Solution();
	    // Test cases
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

        // Output results
        System.out.println("Output for nums1: " + sl.majorityElement(nums1));
        System.out.println("Output for nums2: " + sl.majorityElement(nums2));
	}

}
