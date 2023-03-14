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
    public int sumNumbers(TreeNode root) {
        ans = 0;
        numbers(root, 0);
        
        return ans;
    }
    
    private void numbers(TreeNode root, int num){
        if(root == null) return ;
        
        if(root.left == null && root.right == null){
            num = num*10 + root.val;
            ans += num;
            num /= 10;
            return ;
        }
        
        num = num*10 + root.val;
        numbers(root.left, num);
        numbers(root.right, num);
        num /= 10;
    }
}