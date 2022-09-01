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
    int ans;
    public int goodNodes(TreeNode root) {
        ans = 0;
        
        countGoodNodes(root, Integer.MIN_VALUE);
        
        return ans;
    }
    
    private void countGoodNodes(TreeNode root, int pathMax){
        if(root == null){
            return;
        }
        
        if(root.val >= pathMax){
            ans++;
            pathMax = root.val;
        }
        
        countGoodNodes(root.left, pathMax);
        
        countGoodNodes(root.right, pathMax);
    }
    
}