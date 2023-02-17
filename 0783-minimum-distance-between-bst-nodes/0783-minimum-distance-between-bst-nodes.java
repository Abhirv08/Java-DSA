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
    public int minDiffInBST(TreeNode root) {
        int pre = Integer.MAX_VALUE;
        TreeNode curr = root;
        int ans = Integer.MAX_VALUE;
        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                ans = Math.min(ans, Math.abs(pre - curr.val));
                pre = curr.val;
                curr = curr.right;
                continue;
            }
            while(left.right != null && left.right != curr){
                left = left.right;
            }
            if(left.right == curr){
                left.right = null;
                ans = Math.min(ans, Math.abs(pre - curr.val));
                pre = curr.val;
                curr = curr.right;
            }else{
                left.right = curr;    
                curr = curr.left;
            }            
        }
        
        return ans;
    }
}