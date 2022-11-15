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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int left = 0, right = 0;
        TreeNode temp = root;
        while(temp.left != null){
            temp = temp.left;
            left++;
        }
        temp = root;
        while(temp.right != null){
            temp = temp.right;
            right++;
        }
        
        if(left == right){
            return 2*((int)Math.pow(2, left) - 1) + 1;
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}