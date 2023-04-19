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
    int maxSteps;
    public int longestZigZag(TreeNode root) {
        maxSteps = 0;
        longestPath(root, 0, 0);
        return maxSteps;
    }
    
    private void longestPath(TreeNode root, int left, int right){
        if(root == null) return ;
        maxSteps = Math.max(maxSteps, Math.max(left, right));
        
        if(root.left != null){
            longestPath(root.left, right+1, 0);
        }
        
        if(root.right != null){
            longestPath(root.right, 0, left+1);
        }
        
        return;
    }
}