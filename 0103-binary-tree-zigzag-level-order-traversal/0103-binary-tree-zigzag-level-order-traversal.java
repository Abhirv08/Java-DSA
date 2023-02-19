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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int dir = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> temp = new ArrayList<>();
            while(sz-- > 0){
                TreeNode node = q.poll();
                
                temp.add(node.val);
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            
            if(dir == -1){
                Collections.reverse(temp);
            }
            dir *= -1;
            list.add(temp);
        }
        
        return list;
    }
}