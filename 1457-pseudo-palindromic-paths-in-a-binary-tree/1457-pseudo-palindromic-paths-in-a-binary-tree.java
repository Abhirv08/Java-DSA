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
    int ans;
    public int pseudoPalindromicPaths(TreeNode root) {
        
        HashSet<Integer> set = new HashSet<>();
        ans = 0;
        visitNodes(root, set);       
        
        return ans;
    }
    
    private void visitNodes(TreeNode root, HashSet<Integer> set){
        if(root == null){            
            return ;
        }        
        
        if(set.contains(root.val)){
            set.remove(root.val);
        }else{
            set.add(root.val);
        }
        
        if(root.right == null && root.left == null && set.size() <= 1){
            ans++;
        }
        
        visitNodes(root.left, new HashSet(set));
        
        visitNodes(root.right, new HashSet(set));
        
        
    }
    
}