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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        
        while(!q.isEmpty()){
            root = q.poll();
            ans++;
            
            if(root.left != null){
                q.add(root.left);
            }
            
            if(root.right != null){
                q.add(root.right);
            }
        }
        
        return ans;
    }
}