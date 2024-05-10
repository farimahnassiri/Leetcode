/*
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * Example 1:
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8], Output: true
 * Example 2:
 * Input: root1 = [1,2,3], root2 = [1,3,2], Output: false
 * Constraints:
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
*/
import java.util.*;

public class Solution {
    private List<Integer> leafValue(TreeNode root, List<Integer> list){
        if(root != null && root.left == null && root.right == null){
            list.add(root.val);
        }
        if(root != null){
            leafValue(root.left, list);
            leafValue(root.right, list);
        }
        return list;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        List<Integer> L1 = leafValue(root1, list1);
        List<Integer> L2 = leafValue(root2, list2); 
        if(L1.size() != L2.size()){
            return false;
        }
        for(int i = 0; i < L1.size(); i++){
        	//using !_.equals() instead of != to ensure values are compared correctly
            if(!L1.get(i).equals(L2.get(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.right = new TreeNode(8);
        root2.right.right.right.right = new TreeNode(9);

        boolean result1 = solution.leafSimilar(root1, root2);
        System.out.println("Example 1:");
        System.out.println("Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]");
        System.out.println("Output: " + result1);
        
        // Example 2
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(3);
        root4.right = new TreeNode(2);

        boolean result2 = solution.leafSimilar(root3, root4);
        System.out.println("\nExample 2:");
        System.out.println("Input: root1 = [1,2,3], root2 = [1,3,2]");
        System.out.println("Output: " + result2);
        
        // Example 3
        TreeNode root5 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(200);

        TreeNode root6 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(200);

        boolean result3 = solution.leafSimilar(root5, root6);
        System.out.println("\nExample 3:");
        System.out.println("Input: root1 = [1,2,200], root2 = [1,2,200]");
        System.out.println("Output: " + result3);
    }
}
