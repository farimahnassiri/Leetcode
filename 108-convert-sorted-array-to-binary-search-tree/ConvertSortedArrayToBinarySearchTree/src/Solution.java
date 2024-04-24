/*Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

Example 1:
Input: nums = [-10,-3,0,5,9], Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
, utput: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in a strictly increasing order.
*/

import java.util.Arrays;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Example 1
        printResult(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}), new int[]{-10, -3, 0, 5, 9});
        
        // Test Example 2
        printResult(solution.sortedArrayToBST(new int[]{1, 3}), new int[]{1, 3});
    }
    
    private static void printResult(TreeNode root, int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.print("Output: ");
        printTree(root);
        System.out.println();
    }
    
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("[]");
            return;
        }
        System.out.print("[" + root.val + ",");
        printTree(root.left);
        System.out.print(",");
        printTree(root.right);
        System.out.print("]");
    }
}