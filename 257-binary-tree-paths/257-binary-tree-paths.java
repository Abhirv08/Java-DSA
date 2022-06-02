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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        String s = new String();
        treePaths(root, ans, s);
        return ans;
    }
    
    private void treePaths(TreeNode root, List<String> ans, String s){
        if(root == null)
            return;
        
        if(s.equals("")){
            s += root.val;
        }else{
            s = s + "->" + root.val;
        }
        
        if(root.left == null && root.right == null)
            ans.add(s);
        
        treePaths(root.left, ans, s);
        treePaths(root.right, ans, s);
        
        return;
    }
}