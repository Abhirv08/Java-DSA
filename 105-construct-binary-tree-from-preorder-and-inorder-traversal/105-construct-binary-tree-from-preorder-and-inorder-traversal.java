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
    int preorderIdx;
    HashMap<Integer, Integer> memo;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {        
        int nodes = preorder.length;
        preorderIdx = 0;
        
        memo = new HashMap<>();
        
        for(int i = 0; i < nodes; i++){
            memo.put(inorder[i], i);
        }  
        
        return constructTree(preorder, 0, nodes - 1);
    } 
    
    private TreeNode constructTree(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preorderIdx]);
        preorderIdx++;
        
        root.left = constructTree(preorder, left, memo.get(root.val) - 1);
        root.right = constructTree(preorder, memo.get(root.val)+1, right);
        
        return root;
    }
}