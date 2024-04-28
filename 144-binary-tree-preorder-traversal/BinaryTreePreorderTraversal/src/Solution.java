import java.util.*;

/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3], Output: [1,2,3]

Example 2:
Input: root = [], Output: []

Example 3:
Input: root = [1], Output: [1]

Constraints:
* The number of nodes in the tree is in the range [0, 100].
* -100 <= Node.val <= 100
*/

class Solution {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null){
            return ls;
        }
        ls.add(root.val);
        ls.addAll(preorderTraversal(root.left));
        ls.addAll(preorderTraversal(root.right));
        return ls;     
    }
    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println("Example 1 Output: " + preorderTraversal(root1)); // Output: [1, 2, 3]

        // Example 2
        TreeNode root2 = null;
        System.out.println("Example 2 Output: " + preorderTraversal(root2)); // Output: []

        // Example 3
        TreeNode root3 = new TreeNode(1);
        System.out.println("Example 3 Output: " + preorderTraversal(root3)); // Output: [1]
    }
}