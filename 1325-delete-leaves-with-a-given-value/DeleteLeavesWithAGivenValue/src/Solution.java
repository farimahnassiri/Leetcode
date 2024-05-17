/*
 * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
 * Note that once you delete a leaf node with value target, if its parent node becomes a leaf node
 * and has the value target, it should also be deleted (you need to continue doing that until you cannot).
 * 
 * Example 1:
 * Input: root = [1,2,3,2,null,2,4], target = 2, Output: [1,null,3,null,4]
 * Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left). 
 * After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
 * 
 * Example 2:
 * Input: root = [1,3,3,3,2], target = 3, Output: [1,3,null,null,2]
 * 
 * Example 3:
 * Input: root = [1,2,null,2,null,2], target = 2, Output: [1]
 * Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
 */

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
    // Helper method to print the tree (in-order traversal)
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(4, null, null)
                )
        );
        int target1 = 2;
        TreeNode result1 = solution.removeLeafNodes(root1, target1);
        solution.printTree(result1);
        System.out.println();

        // Example 2
        TreeNode root2 = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(3, null, null),
                        new TreeNode(2, null, null)
                ),
                null
        );
        int target2 = 3;
        TreeNode result2 = solution.removeLeafNodes(root2, target2);
        solution.printTree(result2);
        System.out.println();

        // Example 3
        TreeNode root3 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(2,
                                new TreeNode(2, null, null),
                                null
                        ),
                        null
                ),
                null
        );
        int target3 = 2;
        TreeNode result3 = solution.removeLeafNodes(root3, target3);
        solution.printTree(result3);
        System.out.println();
    }
}