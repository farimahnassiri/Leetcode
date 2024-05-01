package sumOfLeftLeaves;

/**
 * Given the root of a binary tree, return the sum of all left leaves. 
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7], Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 * Example 2:
 * Input: root = [1], Output: 0
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 */

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int value = 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                value += root.left.val;
            }else {
                value += sumOfLeftLeaves(root.left);
            }
        }
            value += sumOfLeftLeaves(root.right);
        
        return value;
        
    }
    public static void main(String[] args) {
        // Example 1: [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        Solution solution = new Solution();
        int result1 = solution.sumOfLeftLeaves(root1);
        System.out.println("Example 1:");
        System.out.println("Input: root = [3,9,20,null,null,15,7]");
        System.out.println("Output: " + result1); // Expected output: 24
        System.out.println();

        // Example 2: [1]
        TreeNode root2 = new TreeNode(1);

        int result2 = solution.sumOfLeftLeaves(root2);
        System.out.println("Example 2:");
        System.out.println("Input: root = [1]");
        System.out.println("Output: " + result2); // Expected output: 0
    }
}