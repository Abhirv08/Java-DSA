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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int levelSize = 1;
        int currSize = 1;
        double sum = 0;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            currSize--;
            sum += node.val;
            
            if(node.left != null){
                q.add(node.left);
            }
            
            if(node.right != null){
                q.add(node.right);
            }
            
            if(currSize == 0){
                double avg = sum/levelSize;                
                ans.add(avg);
                sum = 0;
                levelSize = q.size();
                currSize = levelSize;
            }            
        }
        
        
        return ans;
    }
}