/**
 * Given a sorted integer array nums and an integer n, add/patch elements to the array
 * such that any number in the range [1, n] inclusive can be formed by the sum of
 * some elements in the array. Return the minimum number of patches required.
 * 
 * Example 1:
 * Input: nums = [1,3], n = 6
 * Output: 1
 * Explanation:
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 * 
 * Example 2:
 * Input: nums = [1,5,10], n = 20
 * Output: 2
 * Explanation: The two patches can be [2, 4].
 * 
 * Example 3:
 * Input: nums = [1,2,2], n = 5
 * Output: 0
 * 
 * Constraints:
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^4
 * nums is sorted in ascending order.
 * 1 <= n <= (2^31) - 1
 */

class Solution {
    public int minPatches(int[] nums, int n) {
        long missing = 1;
        int result = 0;
        int i = 0;
        while(missing <= n){
            if(i < nums.length && nums[i] <= missing){
                missing += nums[i];
                i++;
            } else{
                missing += missing;
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int n1 = 6;
        int[] nums2 = {1, 5, 10};
        int n2 = 20;
        int[] nums3 = {1, 2, 2};
        int n3 = 5;

        printResults(nums1, n1);
        printResults(nums2, n2);
        printResults(nums3, n3);
    }

    public static void printResults(int[] nums, int n) {
    	Solution sl = new Solution();
        int result = sl.minPatches(nums, n);  // Replace with the actual method that computes the result
        System.out.println("nums: " + arrayToString(nums) + ", n: " + n + ", patches required: " + result);
    }
    public static String arrayToString(int[] nums) {
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
}
