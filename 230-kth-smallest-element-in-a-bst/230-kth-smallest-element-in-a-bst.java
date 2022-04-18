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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> vals = new ArrayList<>();
        values(root, vals);
        return vals.get(k-1);
    }
    
    static void values(TreeNode r, List<Integer> vals){
        if(r == null) return;
        values(r.left, vals);
        vals.add(r.val);
        values(r.right, vals);
    }
}