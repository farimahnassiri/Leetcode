/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:
The number of nodes in both trees is in the range [0, 100].
-10^4 <= Node.val <= 10^4
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        
        return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Example 1
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Example 1:");
        System.out.println("Input: p = [1,2,3], q = [1,2,3]");
        System.out.println("Output: " + solution.isSameTree(p1, q1));
        
        // Test Example 2
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("\nExample 2:");
        System.out.println("Input: p = [1,2], q = [1,null,2]");
        System.out.println("Output: " + solution.isSameTree(p2, q2));
        
        // Test Example 3
        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println("\nExample 3:");
        System.out.println("Input: p = [1,2,1], q = [1,1,2]");
        System.out.println("Output: " + solution.isSameTree(p3, q3));
    }    
    
}