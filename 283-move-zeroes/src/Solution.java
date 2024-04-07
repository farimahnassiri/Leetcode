/**
 * Problem:
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 */

public class Solution {
	public void moveZeroes(int[] nums) {
		int counterZero = 0;
	    int j = 0;
	    int n = nums.length;

	    for(int i = 0; i < nums.length; i++){
	    	if(nums[i] != 0){
	    		nums[j] = nums[i];
	            j++;
	    	}
	        else {
	        	counterZero++;
	        }
	    }
	        
	    while(counterZero != 0){
	    	nums[nums.length - counterZero] = 0;
	        counterZero--;
	    }
	}

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(nums1);
        printArray(nums1);

        // Example 2
        int[] nums2 = {0};
        solution.moveZeroes(nums2);
        printArray(nums2);
    }

    // Printer method
    private static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
