/*
* Given the root of a binary tree, invert the tree, and return its root.
* 
* Example 1:
* Input: root = [4,2,7,1,3,6,9], Output: [4,7,2,9,6,3,1]
* 
* Example 2:
* Input: root = [2,1,3], Output: [2,3,1]
* 
* Example 3:
* Input: root = [], Output: []
* 
* Constraints:
* The number of nodes in the tree is in the range [0, 100].
* -100 <= Node.val <= 100
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {    
        if (root == null){
            return root;
        }
        return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }
    // Function to print a binary tree (in-order traversal)
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("[]");
            return;
        }
        System.out.print("[" + root.val);
        printTree(root.left);
        printTree(root.right);
        System.out.print("]");
    }
    
    public static void main(String[] args) {
        // Create the invertTree object
        Solution tree = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        System.out.println("Example 1:");
        System.out.print("Input: ");
        printTree(root1);

        TreeNode invertedRoot1 = tree.invertTree(root1);
        System.out.print("Output: ");
        printTree(invertedRoot1);
        System.out.println();

        // Example 2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        System.out.println("Example 2:");
        System.out.print("Input: ");
        printTree(root2);

        TreeNode invertedRoot2 = tree.invertTree(root2);
        System.out.print("Output: ");
        printTree(invertedRoot2);
        System.out.println();

        // Example 3
        TreeNode root3 = null;

        System.out.println("Example 3:");
        System.out.print("Input: ");
        printTree(root3);

        TreeNode invertedRoot3 = tree.invertTree(root3);
        System.out.print(", Output: ");
        printTree(invertedRoot3);
    }
}