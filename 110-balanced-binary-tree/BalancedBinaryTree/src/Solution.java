/*
Given a binary tree, determine if it is height-balanced.

Example 1:
Input: root = [3,9,20,null,null,15,7], Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4], Output: false

Example 3:
Input: root = [], Output: true

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-10^4 <= Node.val <= 10^4
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Height(root) == -1){
            return false;
        }
        return true;
    }
    public int Height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);
        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Example 1
        TreeNode root1 = new TreeNode(3,
                                new TreeNode(9),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Example 1:");
        System.out.println("Input: root = [3,9,20,null,null,15,7]");
        System.out.println("Output: " + solution.isBalanced(root1));
        
        // Test Example 2
        TreeNode root2 = new TreeNode(1,
                                new TreeNode(2,
                                    new TreeNode(3, new TreeNode(4), new TreeNode(4)),
                                    new TreeNode(3)),
                                new TreeNode(2));
        System.out.println("\nExample 2:");
        System.out.println("Input: root = [1,2,2,3,3,null,null,4,4]");
        System.out.println("Output: " + solution.isBalanced(root2));
        
        // Test Example 3
        TreeNode root3 = null;
        System.out.println("\nExample 3:");
        System.out.println("Input: root = []");
        System.out.println("Output: " + solution.isBalanced(root3));
    }
}