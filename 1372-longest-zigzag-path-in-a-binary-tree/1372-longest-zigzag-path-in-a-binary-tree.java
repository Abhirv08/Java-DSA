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
    public int longestZigZag(TreeNode root) {
         return longestPath(root, 'b', new HashMap<>());
    }
    
    private int longestPath(TreeNode root, char dir, HashMap<String, Integer> map){
        if(root == null) return -1;
        
        String key = root + ":" + dir;
        if(map.containsKey(key)) return map.get(key);
        
        int max = 0;
        if(dir != 'r'){
            int path = 1 + longestPath(root.right, 'r', map);
            if(max < path) max = path;
        }
        if(dir != 'l'){
            int path = 1 + longestPath(root.left, 'l', map);
            if(max < path) max = path;
        }
        if(dir == 'b'){
            int leftPath = longestPath(root.left, dir, map);
            int rightPath = longestPath(root.right, dir, map);
            max = Math.max(max, Math.max(leftPath, rightPath));
        }
        
        map.put(key, max);
        return max;
    }
}