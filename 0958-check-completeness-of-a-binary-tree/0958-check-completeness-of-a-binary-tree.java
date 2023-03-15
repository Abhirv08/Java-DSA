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
    public boolean isCompleteTree(TreeNode root) {
        boolean nullEncounterd = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                TreeNode node = q.poll();
                
                if(node == null){
                    nullEncounterd = true;
                    continue;
                }
                
                if(node.val > 0 && nullEncounterd) return false;
                
                if(node.left != null) {
                    q.add(node.left);
                }else{
                    q.add(null);
                }
                
                if(node.right != null){
                    q.add(node.right);
                }else{
                    q.add(null);
                }
            }
        }
        
        return true;
    }
}