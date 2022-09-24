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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        
        pathSum(root, targetSum, new ArrayList<>());
        return res;
    }
    
    private void pathSum(TreeNode root, int targetSum, List<Integer> list){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            list.add(root.val);
            if(targetSum == root.val){
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return ;
        }
        
        list.add(root.val);
        pathSum(root.left, targetSum - root.val, list);
        pathSum(root.right, targetSum - root.val, list);
        list.remove(list.size() - 1);
        
        return;
    }
    
}