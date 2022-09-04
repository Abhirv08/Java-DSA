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

class Tuple{
    TreeNode node;
    int row, col;
    
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        
        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode node = t.node;
            int x = t.row;
            int y = t.col;
            
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            
            map.get(x).get(y).offer(node.val);
            
            if(t.node.left != null){
                q.add(new Tuple(node.left, x - 1, y + 1));
            }
            
            if(t.node.right != null){
                q.add(new Tuple(node.right, x + 1, y + 1));
            }
        }
        
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> x : map.values()){
            list.add(new ArrayList<>());
            
            for(PriorityQueue<Integer> nodes : x.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
            
        }
        
        return list;
    }
}