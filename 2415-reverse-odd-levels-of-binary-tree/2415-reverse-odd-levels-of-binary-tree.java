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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        List<List<TreeNode>> toBeReversed = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        int LevelSize = q.size();
        int currLevel = 0;
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            LevelSize--;
            
            if(currLevel%2 == 1){
                temp.add(node);
            }
            
            
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
            
            
            if(LevelSize == 0){
                currLevel++;
                LevelSize = q.size();
                if(temp.size() > 0){
                    toBeReversed.add(temp);
                    temp = new ArrayList<>();
                }
            }
            
        }
        
        // for(List<TreeNode> l: toBeReversed){
        //     for(TreeNode t: l){
        //         System.out.print(t.val);
        //     }
        //     System.out.println();
        // }
        
        for(int i = 0; i < toBeReversed.size(); i++){
            List<TreeNode> levelList = toBeReversed.get(i);
            List<Integer> levelValues = new ArrayList<>();
            for(TreeNode node: levelList){
                levelValues.add(node.val);
            }
            Collections.reverse(levelValues);
            int idx = 0;
            for(TreeNode node: levelList){
                node.val = levelValues.get(idx);
                idx++;
            }            
        }
        
        return root;
    }
}