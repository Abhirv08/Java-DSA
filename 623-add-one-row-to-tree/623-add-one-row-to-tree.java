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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            
            return node;
            
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        
        while(depth > 2){
            Queue<TreeNode> temp = new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode node = q.remove();
                
                if(node.left != null) temp.add(node.left);
                if(node.right != null) temp.add(node.right);
            }
            q = temp;
            depth--;
        }
        
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(val, null, null);
            node.left.left = temp;
            
            temp = node.right;
            node.right = new TreeNode(val, null, null);
            node.right.right = temp;
        }
        
        
        
        return root;
    }
}