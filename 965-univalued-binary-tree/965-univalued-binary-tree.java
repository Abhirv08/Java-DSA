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
    public boolean isUnivalTree(TreeNode root) {
        
        return checking(root, root.val) ;
    }
    
    private boolean checking(TreeNode root, int value){
        if(root == null)
            return true;
        if(root.val != value)
            return false;
        
        return checking(root.left, value) && checking(root.right, value);
    }
}