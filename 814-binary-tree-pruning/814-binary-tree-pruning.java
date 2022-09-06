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
    public TreeNode pruneTree(TreeNode root) {
        
        
        return removeTreeNode(root) ? root : null;
    }
    
    private boolean removeTreeNode(TreeNode root){
        if(root == null){
            return false;
        }
        
        boolean leftHasOnes = removeTreeNode(root.left);
        
        if(!leftHasOnes){
            root.left = null;
        }
        
        boolean rightHasOnes = removeTreeNode(root.right);
        
        if(!rightHasOnes){
            root.right = null;
        }
        
        return (leftHasOnes || rightHasOnes) || root.val == 1;
    }
}