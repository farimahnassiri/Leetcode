/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/
package recursiveSolution;

import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // inorder traversal :: Left-Root-Right
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result; 
    }
    private void inorder(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Example 1
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println("Example 1:");
        System.out.println("Input: root = [1,null,2,3]");
        System.out.println("Output: " + solution.inorderTraversal(root1));
        
        // Test Example 2
        TreeNode root2 = null;
        System.out.println("\nExample 2:");
        System.out.println("Input: root = []");
        System.out.println("Output: " + solution.inorderTraversal(root2));
        
        // Test Example 3
        TreeNode root3 = new TreeNode(1);
        System.out.println("\nExample 3:");
        System.out.println("Input: root = [1]");
        System.out.println("Output: " + solution.inorderTraversal(root3));
    }
}
