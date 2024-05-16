class Solution {
    public boolean evaluateTree(TreeNode root) {
    	if(root == null) {
    		return false;
    	}
    	if(root.val == 0) {
    		return false;
    	}
    	if(root.val == 1) {
    		return true;
    	}
    	if(root.val == 2) {
    		return evaluateTree(root.left) || evaluateTree(root.right);
    	}
    	if(root.val == 3) {
    		return evaluateTree(root.left) && evaluateTree(root.right);
    	}
    	
        return false;
    }
    public static void main(String[] args) {
        // Test example 1
    	Solution sl1 = new Solution();
    	Solution sl2 = new Solution();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(1);
        System.out.println(sl1.evaluateTree(root1));  // Output: true

        // Test example 2
        TreeNode root2 = new TreeNode(0);
        System.out.println(sl2.evaluateTree(root2));  // Output: false
    }
}