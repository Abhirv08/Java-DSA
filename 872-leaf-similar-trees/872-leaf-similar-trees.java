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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> memo1 = new ArrayList<>();
        List<Integer> memo2 = new ArrayList<>();
        
        leafs(root1, memo1);
        leafs(root2, memo2);
        if(memo1.size() != memo2.size())
            return false;
        else
            for(int i = 0; i < memo1.size();i++)
                if(memo1.get(i) != memo2.get(i))
                    return false;
        
        return true;
    }
    
    private void leafs(TreeNode root, List<Integer> memo){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null)
            memo.add(root.val);
            
        
        leafs(root.left, memo);
        leafs(root.right, memo);
        
        return;
            
    }
}