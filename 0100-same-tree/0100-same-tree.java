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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null && p != null) || (p != null && q == null)) return false;
        
        Queue<TreeNode> forP = new LinkedList<>();
        forP.add(p);
        Queue<TreeNode> forQ = new LinkedList<>();
        forQ.add(q);
        
        while(!forP.isEmpty() && !forQ.isEmpty()){
            TreeNode p_node = forP.poll();
            TreeNode q_node = forQ.poll();
            
            if(!check(p_node, q_node)) return false;
            
            if(p_node != null){
                if(!check(p_node.left, q_node.left)) return false;
                if(p_node.left != null){
                    forP.add(p_node.left);
                    forQ.add(q_node.left);
                }
                
                if(!check(p_node.right, q_node.right)) return false;
                if(p_node.right != null){
                    forP.add(p_node.right);
                    forQ.add(q_node.right);
                }  
            }          
        }
        
        return true;
    }
    
    private boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        
        if((p == null && q != null) || (p != null && q == null)) return false;
        
        return p.val == q.val;
    }
}