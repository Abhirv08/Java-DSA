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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> dq = new LinkedList<>();
        if(root == null) return ans;
        dq.add(root);
        while(!dq.isEmpty()){
            List<Integer> sublist = new ArrayList<>();
            int levelsize = dq.size();
            for(int  i = 0 ; i < levelsize; i++){
                TreeNode temp = dq.peek();
                if(temp.left != null) dq.add(temp.left);
                if(temp.right != null) dq.add(temp.right);
                sublist.add(dq.poll().val);
            }
            ans.add(sublist);
        }
        return ans;
    }
}