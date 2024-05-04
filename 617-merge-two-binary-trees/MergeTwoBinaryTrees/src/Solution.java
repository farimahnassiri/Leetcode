/*
* You are given two binary trees root1 and root2. Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree. Return the merged tree. Note: The merging process must start from the root nodes of both trees.
* Example 1: Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7] Output: [3,4,5,5,4,null,7] Example 2: Input: root1 = [1], root2 = [1,2] Output: [2,2]
* Constraints: The number of nodes in both trees is in the range [0, 2000]. -10^4 <= Node.val <= 10^4
*/

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        root1.val += root2.val;
        
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode merged1 = solution.mergeTrees(root1, root2);
        System.out.print("Example 1 Merged Tree: ");
        printTree(merged1);
        System.out.println();

        // Example 2
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);

        TreeNode merged2 = solution.mergeTrees(root3, root4);
        System.out.print("Example 2 Merged Tree: ");
        printTree(merged2);
        System.out.println();
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}