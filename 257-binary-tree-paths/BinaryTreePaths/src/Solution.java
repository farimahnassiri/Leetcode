import java.util.*;
/*
* Given the root of a binary tree, return all root-to-leaf paths in any order. A leaf is a node with no children.
* Example 1: Input: root = [1,2,3,null,5] Output: ["1->2->5","1->3"]
* Example 2: Input: root = [1] Output: ["1"]
* Constraints: The number of nodes in the tree is in the range [1, 100]. -100 <= Node.val <= 100
*/

class Solution {
    private void searchBinaryTree(TreeNode root, String path, List<String> list){
        if(root.left == null && root.right == null){
            list.add(path + root.val);
        }
        if(root.left != null){
            searchBinaryTree(root.left, path + root.val + "->", list);
        }
        if(root.right != null){
            searchBinaryTree(root.right, path + root.val + "->", list);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<String>();
        if(root != null){
            searchBinaryTree(root, "", ls);
        }
        return ls;
    }
    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        Solution solution = new Solution();
        List<String> paths1 = solution.binaryTreePaths(root1);
        System.out.println("Example 1:");
        System.out.println("Input: root = [1,2,3,null,5]");
        System.out.println("Output: " + paths1);

        // Example 2
        TreeNode root2 = new TreeNode(1);
        List<String> paths2 = solution.binaryTreePaths(root2);
        System.out.println("\nExample 2:");
        System.out.println("Input: root = [1]");
        System.out.println("Output: " + paths2);
    }
}