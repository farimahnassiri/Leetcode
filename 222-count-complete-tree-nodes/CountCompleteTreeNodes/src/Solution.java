// Given the root of a complete binary tree, return the number of nodes in the tree.
// According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
// Design an algorithm that runs in less than O(n) time complexity.
// Example 1: Input: root = [1,2,3,4,5,6] Output: 6
// Example 2: Input: root = [] Output: 0
// Example 3: Input: root = [1] Output: 1
// Constraints: * The number of nodes in the tree is in the range [0, 5 * 10^4]. * 0 <= Node.val <= 5 * 10$4 * The tree is guaranteed to be complete.

class Solution {
    int counter = 0;
    private int totalCount(TreeNode root){
        if(root == null){
            return counter;
        }
        totalCount(root.left);
        totalCount(root.right);
        counter++;
        return counter;
    }

    public int countNodes(TreeNode root) {
        totalCount(root);
        return counter;
    }
    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.print("Example 1 Output: ");
        printer(root1); // Output: 1, 2, 4, 5, 3, 6

        // Example 2
        TreeNode root2 = null;
        System.out.print("Example 2 Output: ");
        printer(root2); // Output: 

        // Example 3
        TreeNode root3 = new TreeNode(1);
        System.out.print("Example 3 Output: ");
        printer(root3); // Output: 1
    }

    public static void printer(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        printInOrder(root, sb);
        System.out.println(sb.toString());
    }

    private static void printInOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        printInOrder(root.left, sb);
        sb.append(root.val).append(", ");
        printInOrder(root.right, sb);
    }
}