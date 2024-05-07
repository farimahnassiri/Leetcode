/** Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
* Example 1:
* Input: root = [5,3,6,2,4,null,7], k = 9, Output: true
* Example 2:
* Input: root = [5,3,6,2,4,null,7], k = 28, Output: false
* Constraints:
* The number of nodes in the tree is in the range [1, 10^4].
* -10^4 <= Node.val <= 10^4
* root is guaranteed to be a valid binary search tree.
* -10^5 <= k <= 10^5
*/

class Solution {
    static int c = 0;
    static TreeNode temp = null;

    public static boolean search(TreeNode node, TreeNode root, int val) {
        if (node == null) {
            return false;
        } else if (node.val == val && node != root) {
            return true;
        }
        if (node.val > val) {
            return search(node.left, root, val);
        } else {
            return search(node.right, root, val);
        }
    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (c == 0) {
            temp = root;
            c = -1;
        }
        boolean f1 = findTarget(root.left, k);
        if (f1 == true) {
            return true;
        }
        if (search(temp, root, k - root.val) == true) {
            return true;
        }
        boolean f2 = findTarget(root.right, k);
        if (f2 == true) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);
        int k1 = 9;
        System.out.println("Example 1:");
        System.out.println("Input: root = [5,3,6,2,4,null,7], k = 9");
        System.out.println("Output: " + findTarget(root1, k1)); // Expected output: true
        
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        int k2 = 28;
        System.out.println("Example 2:");
        System.out.println("Input: root = [5,3,6,2,4,null,7], k = 28");
        System.out.println("Output: " + findTarget(root2, k2)); // Expected output: false
    }
}