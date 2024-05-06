/*
* Given the roots of two binary trees root and subRoot,
* return true if there is a subtree of root with the same
* structure and node values of subRoot and false otherwise.
* A subtree of a binary tree tree is a tree that consists
* of a node in tree and all of this node's descendants.
* The tree tree could also be considered as a subtree of itself.
* Example 1:
* Input: root = [3,4,5,1,2], subRoot = [4,1,2]
* Output: true
* Example 2:
* Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
* Output: false
* Constraints:
* - The number of nodes in the root tree is in the range [1, 2000].
* - The number of nodes in the subRoot tree is in the range [1, 1000].
* - -10^4 <= root.val <= 10^4
* - -10^4 <= subRoot.val <= 10^4
*/

public class Solution {
    private boolean isSubtreeHelper(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root == null && subRoot == null){
            return true;
        }
        if(root.val != subRoot.val){
            return false;  
        }
        return isSubtreeHelper(root.left, subRoot.left) && isSubtreeHelper(root.right, subRoot.right);  
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(isSubtreeHelper(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(3);
//        root1.left = new TreeNode(4);
//        root1.right = new TreeNode(5);
//        root1.left.left = new TreeNode(1);
//        root1.left.right = new TreeNode(2);
//
//        TreeNode subRoot1 = new TreeNode(4);
//        subRoot1.left = new TreeNode(1);
//        subRoot1.right = new TreeNode(2);
//
//        System.out.println(isSubtree(root1, subRoot1)); // Output: true

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(2);
        root2.right.right = new TreeNode(0);

        TreeNode subRoot2 = new TreeNode(4);
        subRoot2.left = new TreeNode(1);
        subRoot2.right = new TreeNode(2);

        System.out.println(isSubtree(root2, subRoot2)); // Output: false
    }
}
