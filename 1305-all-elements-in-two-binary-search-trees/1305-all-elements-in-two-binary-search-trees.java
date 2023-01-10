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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> r1_nodes = new ArrayList<>();
        List<Integer> r2_nodes = new ArrayList<>();
        inOrder(root1, r1_nodes);
        inOrder(root2, r2_nodes);
        
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        
        while(i < r1_nodes.size() && j < r2_nodes.size()){
            int r1_node = r1_nodes.get(i);
            int r2_node = r2_nodes.get(j);
            if(r1_node <= r2_node){
                ans.add(r1_node);
                i++;
            }else{
                ans.add(r2_node);
                j++;
            }
        }
        
        while(i < r1_nodes.size()){
            int r1_node = r1_nodes.get(i);
            ans.add(r1_node);
            i++;
        }
        
        while(j < r2_nodes.size()){
            int r2_node = r2_nodes.get(j);
            ans.add(r2_node);
            j++;
        }
        
        return ans;
    }
    
    private void inOrder(TreeNode root, List<Integer> list){
        if(root == null) return ;
        
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
        
        return ;
    }
}