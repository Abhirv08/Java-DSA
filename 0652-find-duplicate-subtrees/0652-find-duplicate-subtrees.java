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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        findDuplicates(root, map, list);
        return list;
    }
    
    private String findDuplicates(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list){
        if(root == null) return "#";
        
        String key = findDuplicates(root.left, map, list) + ":" + findDuplicates(root.right, map, list) + ":" + root.val;
        
        map.put(key, map.getOrDefault(key, 0) + 1);
        if(map.get(key) == 2){
            list.add(root);            
        }
        
        return key;
    }
}