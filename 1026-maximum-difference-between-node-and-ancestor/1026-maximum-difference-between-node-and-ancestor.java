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
    int result;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null){
            return 0;
        }
        result = 0;
        getMaxDiff(root, root.val, root.val);
        
        return result;
    }
    
    private void getMaxDiff(TreeNode root, int curMax, int curMin){
        if(root == null){
            return ;
        }
        
        int posRes = Math.max(Math.abs(curMax - root.val), Math.abs(curMin - root.val));
        result = Math.max(result, posRes);
        
        curMax = Math.max(curMax, root.val);
        curMin = Math.min(curMin, root.val);
        
        getMaxDiff(root.left, curMax, curMin);
        getMaxDiff(root.right, curMax, curMin);
    }
    
}