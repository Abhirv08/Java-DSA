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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return findTarget(ans , k);
    }
    
    static void inOrder(TreeNode root, List<Integer> ans){
        if(root == null) return ;
        
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
    
    static boolean findTarget(List<Integer> ans, int k){
        int start = 0;
        int end = ans.size()-1;
        while(start < end){
            if(ans.get(start) + ans.get(end) == k){
                return true;
            }else if(ans.get(start) + ans.get(end) > k){
                end--;
            }else{
                start++;
            }
        }
        return false;
    }
}