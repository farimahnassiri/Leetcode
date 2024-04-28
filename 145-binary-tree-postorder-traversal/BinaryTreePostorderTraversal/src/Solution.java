// Given the root of a binary tree, return the postorder traversal of its nodes' values.
// Example 1: Input: root = [1,null,2,3] Output: [3,2,1]
// Example 2: Input: root = [] Output: []
// Example 3: Input: root = [1] Output: [1]
// Constraints: * The number of the nodes in the tree is in the range [0, 100]. * -100 <= Node.val <= 100

import java.util.*;

class Solution {
    List<Integer> ls = new ArrayList<>();
    private void postOrder(TreeNode root){
        if(root == null){
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        ls.add(root.val);
        return;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return ls; 
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        // Example 1
        System.out.println("Example 1 Output: " + solution.postorderTraversal(root1)); // Output: [3, 2, 1]
        // Example 2
        TreeNode root2 = null;
        System.out.println("Example 2 Output: " + solution.postorderTraversal(root2)); // Output: []
        // Example 3
        TreeNode root3 = new TreeNode(1);
        System.out.println("Example 3 Output: " + solution.postorderTraversal(root3)); // Output: [1]
    }
}