/*
* Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
* If there are multiple answers, print the smallest.
* Example 1: Input: root = [4,2,5,1,3], target = 3.714286 Output: 4
* Example 2: Input: root = [1], target = 4.428571 Output: 1
* Constraints: The number of nodes in the tree is in the range [1, 104]. 0 <= Node.val <= 10^9 && -10^9 <= target <= 10^9
*/

class Solution {
    public int closestValue(TreeNode root, double target) {
        int value = root.val;

        while(root != null){
            int current = root.val;
            if(Math.abs(current - target) < Math.abs(value - target)){
                value = current;
            }
            else if(Math.abs(current - target) == Math.abs(value - target)){
                value = Math.min(current, value);
            }
            root = target < root.val ? root.left : root.right;
        }
        return value;
    }
    public static void main(String[] args) {
        // Creating instances of the binary tree for each example
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);

        // Creating an instance of the solution class
        Solution solution = new Solution();

        // Test case 1
        double target1 = 3.714286;
        System.out.println("Example 1:");
        System.out.println("Input: root = [4,2,5,1,3], target = 3.714286");
        System.out.println("Output: " + solution.closestValue(root1, target1));

        // Test case 2
        double target2 = 4.428571;
        System.out.println("\nExample 2:");
        System.out.println("Input: root = [1], target = 4.428571");
        System.out.println("Output: " + solution.closestValue(root2, target2));
    }
}