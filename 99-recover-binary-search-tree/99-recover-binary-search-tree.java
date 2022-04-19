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
    static TreeNode prev, first, mid, last;
    public void recoverTree(TreeNode root) {
        prev = first = mid = last = null;
        inOrder(root);
        if(last == null){
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }else{
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }
    
    static void inOrder(TreeNode root){
        if(root ==null) return;
        inOrder(root.left);
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
                mid = root;
            }else{
                last = root;
            }            
        } 
        prev = root;
        inOrder(root.right);
    }
}