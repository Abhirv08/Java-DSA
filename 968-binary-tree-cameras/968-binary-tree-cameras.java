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
    // -1 ---> I need a camera
    // 0 ---> i have a camera
    // 1 ---> i don't need camera
    public int cameras = 0;
    public int minCameraCover(TreeNode root) {
        int childResponse = minCamera(root);
        if(childResponse == -1){
            return cameras + 1;
        }
        return cameras;
    }
    
    private int minCamera(TreeNode root){
        if(root == null) return 1;
        
        int leftChild = minCamera(root.left);
        int rightChild = minCamera(root.right);
        
        if(leftChild == -1 || rightChild == -1){
            cameras++;
            return 0;
        }
        
        if(leftChild == 0 || rightChild == 0){
            return 1;
        }
        
        return -1;
    }
}