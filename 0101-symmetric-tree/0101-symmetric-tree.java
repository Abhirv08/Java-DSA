/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    boolean isSymmetric(TreeNode root1, TreeNode root2){
        if(root1 == null) return root2 == null;
        if(root2 == null) return false;
        
        if(root1.val != root2.val) return false;
        
        boolean left = isSymmetric(root1.left, root2.right);
        boolean right = isSymmetric(root1.right, root2.left);
        
        return left & right;
    }
}