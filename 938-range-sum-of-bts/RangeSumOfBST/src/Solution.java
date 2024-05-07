
class Solution {
    public int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {  
        if(root == null){
            return sum;
        }
        if(root.val >= low && root.val <= high){
            sum += root.val;
        }
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);
        return sum;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        root1.right.right = new TreeNode(18);
        int low1 = 7;
        int high1 = 15;
        System.out.println("Example 1:");
        Solution sl1 = new Solution();
        Solution sl2 = new Solution();
        System.out.println("Input: root = [10,5,15,3,7,null,18], low = 7, high = 15, Output: " + sl1.rangeSumBST(root1, low1, high1)); // Output: 32

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(18);
        root2.left.left.left = new TreeNode(1);
        root2.left.right.left = new TreeNode(6);
        int low2 = 6;
        int high2 = 10;
        System.out.println("Example 2:");
        System.out.println("Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10, Output: " + sl2.rangeSumBST(root2, low2, high2)); // Output: 23
    }
}