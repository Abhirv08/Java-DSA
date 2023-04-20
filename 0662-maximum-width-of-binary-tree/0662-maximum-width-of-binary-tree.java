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
class Pair{
    TreeNode node;
    long val;
    
    public Pair(TreeNode node, long val){
        this.node = node;
        this.val = val;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        int ans = 1;
        
        while(!q.isEmpty()){
            int sz = q.size();
            long startNum = q.peek().val;
            long lastNum = q.peekLast().val;
            
            ans = Math.max(ans, (int) (lastNum - startNum + 1));
            
            while(sz-- > 0){
                Pair pair = q.poll();
                TreeNode cur = pair.node;
                long curVal = pair.val;
                
                if(cur.left != null){
                    q.add(new Pair(cur.left, 2*curVal + 1));
                }
                
                if(cur.right != null){
                    q.add(new Pair(cur.right, 2*curVal + 2 ));
                }
            }
        }
        
        return ans;
    }
}