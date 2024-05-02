/*
* Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
* If the tree has more than one mode, return them in any order.
* Assume a BST is defined as follows:
* The left subtree of a node contains only nodes with keys less than or equal to the node's key.
* The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
* Both the left and right subtrees must also be binary search trees.
* 
* Example 1:
* Input: root = [1,null,2,2], Output: [2]
* Example 2:
* Input: root = [0], Output: [0]
* 
* Constraints:
* The number of nodes in the tree is in the range [1, 10^4]. -10^5 <= Node.val <= 10^5
*/

import java.util.*;

class Solution {
    private int currentVal;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null){
            return;
        }

        inOrderTraversal(node.left);
        currentCount = (node.val == currentVal) ? currentCount + 1 : 1;
        
        if (currentCount == maxCount) {
            modes.add(node.val);
        } else if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        }
        currentVal = node.val;

        inOrderTraversal(node.right);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

//        // Example 1
//        TreeNode root1 = new TreeNode(1);
//        root1.right = new TreeNode(2);
//        root1.right.left = new TreeNode(2);
//        int[] result1 = solution.findMode(root1);
//        System.out.print("Example 1 Output: ");
//        for (int val : result1) {
//            System.out.print(val + " ");
//        }
//        System.out.println();

        // Example 2
        TreeNode root2 = new TreeNode(0);
        int[] result2 = solution.findMode(root2);
        System.out.print("Example 2 Output: ");
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}