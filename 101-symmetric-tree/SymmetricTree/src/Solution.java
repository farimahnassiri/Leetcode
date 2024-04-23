/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        //TreeNode leftNode = root.left;
        if(root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null){
            return true;
        }
        if(n1 == null || n2 == null){
            return false;
        }
        return n1.val == n2.val && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Example 1
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println("Example 1:");
        System.out.println("Input: root = [1,2,2,3,4,4,3]");
        System.out.println("Output: " + solution.isSymmetric(root1));
        
        // Test Example 2
        TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println("\nExample 2:");
        System.out.println("Input: root = [1,2,2,null,3,null,3]");
        System.out.println("Output: " + solution.isSymmetric(root2));
    }
}