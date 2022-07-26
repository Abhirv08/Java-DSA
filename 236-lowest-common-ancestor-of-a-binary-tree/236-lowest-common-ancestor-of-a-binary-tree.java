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
    
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        recursiveTree(root, p, q);
        return ans;
    }
    
    private boolean recursiveTree(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        
        int left = recursiveTree(root.left, p, q) ? 1 : 0;
        
        int right = recursiveTree(root.right, p,  q) ? 1 : 0;
        
        int mid = (root == p || root == q) ? 1 : 0;
        
        if(mid + left + right >= 2){
            ans = root;
        }
        
        return (mid + left + right) > 0;
    }
}