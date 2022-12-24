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
    private int index;
    private int[] st, ed, depthArr;
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = countNodes(root);
        st = new int[n+1]; ed = new int[n+1];
        
        index = 0;
        findStartAndEnd(root);
        
        depthArr = new int[n+1];
        findDepth(root, 0);
        
        int[] prefixMax = new int[n+2];
        for(int i = 1; i < n+1; i++){
            prefixMax[i] = Math.max(prefixMax[i - 1], depthArr[i]);
        }
        
        int[] suffixMax = new int[n+2];
        for(int i = n; i > 0; i--){
            suffixMax[i] = Math.max(suffixMax[i + 1], depthArr[i]);
        }
        // System.out.println(Arrays.toString(st));
        // System.out.println(Arrays.toString(ed));
        // System.out.println(Arrays.toString(depthArr));
        // System.out.println(Arrays.toString(prefixMax));
        // System.out.println(Arrays.toString(suffixMax));
        
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int node = queries[i];
            int start = st[node];
            int end = ed[node];
            ans[i] = Math.max(prefixMax[start - 1], suffixMax[end+1]);
        }
        
        return ans;
    }
    
    private void findDepth(TreeNode root, int depth){
        if(root == null) return ;        
        
        depthArr[st[root.val]] = depth;
        
        findDepth(root.left, depth+1);
        findDepth(root.right, depth+1);
    }
    
    private void findStartAndEnd(TreeNode root){
        if(root == null){
            return;
        }
        
        index++;
        st[root.val] = index;
        
        findStartAndEnd(root.left);
        findStartAndEnd(root.right);
        
        ed[root.val] = index;
        
    }
    
    private int countNodes(TreeNode root){
        if(root == null) return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}