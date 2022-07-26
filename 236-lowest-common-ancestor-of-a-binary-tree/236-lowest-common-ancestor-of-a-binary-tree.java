/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return recursiveTree(root, p, q);
    }
    
    private TreeNode recursiveTree(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        
        if(root == p || root == q){
            return root;
        }
        
        TreeNode left = recursiveTree(root.left, p, q);
        
        TreeNode right = recursiveTree(root.right, p,  q);
        
        if(left != null && right != null){
            return root;
        }
        
        if(left == null && right != null){
            return right;
        }
        
        if(left != null && right == null){
            return left;
        }
        
        return null;
    }
}