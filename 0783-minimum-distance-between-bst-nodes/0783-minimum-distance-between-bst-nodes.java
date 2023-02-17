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
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        
        System.out.println(list);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < list.size()-1; i++){
            ans = Math.min(ans, list.get(i+1) - list.get(i));
        }
        
        return ans;
    }
    
    void postOrder(TreeNode root, List<Integer> list){
        if(root == null) return ;
        
        postOrder(root.left, list);
        list.add(root.val);
        postOrder(root.right, list);
    }
    
    
}