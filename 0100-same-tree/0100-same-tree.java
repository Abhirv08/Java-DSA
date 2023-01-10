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
        List<Integer> p_nodes = findNodes(p);
        List<Integer> q_nodes = findNodes(q);
        
        if(p_nodes.size() != q_nodes.size()) return false;
        
        for(int i = 0; i < p_nodes.size(); i++){
            if(Integer.compare(p_nodes.get(i), q_nodes.get(i)) != 0){
                System.out.println(p_nodes.get(i) +":" + q_nodes.get(i));
                return false;
            }
        }
        
        return true;
    }
    
    private List<Integer> findNodes(TreeNode root){
        List<Integer> nodes = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz-- > 0){
                TreeNode node = q.poll();
                if(node != null) nodes.add(node.val);
                else nodes.add(100000);
                
                if(node == null || (node.left == null && node.right == null)){
                    continue;
                }
                
                if(node.left != null){
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
        
        return nodes;
    }
}