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
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        
        if(root.left == null && root.right == null){
            return ;
        }
        
        flattening(root);
                
    }
    
    TreeNode prev = null;
    private void flattening(TreeNode root){
        if(root == null){
            return ;
        }
        
        flattening(root.right);
        flattening(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}