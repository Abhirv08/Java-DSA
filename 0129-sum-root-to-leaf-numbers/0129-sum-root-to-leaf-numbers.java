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
        numbers(root, new StringBuilder());
        
        return ans;
    }
    
    private void numbers(TreeNode root, StringBuilder num){
        if(root == null) return ;
        
        if(root.left == null && root.right == null){
            num.append(root.val);
            ans += Integer.parseInt(new String(num));
            num.delete(num.length() - 1, num.length());
            return ;
        }
        
        num.append(root.val);
        numbers(root.left, num);
        numbers(root.right, num);
        num.delete(num.length() - 1, num.length());
    }
}