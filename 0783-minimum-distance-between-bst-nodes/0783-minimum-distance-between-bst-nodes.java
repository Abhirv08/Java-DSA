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
    TreeNode prevVal;
    int ans;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
    
    void dfs(TreeNode root){
        if(root == null) return ;
        
        dfs(root.left);
        if(prevVal != null) ans = Math.min(ans, Math.abs(root.val - prevVal.val));
        prevVal = root;
        dfs(root.right);
    }
}