/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int curr_size = 1;
        
        List<Integer> level = new ArrayList<>();
        while(!q.isEmpty()){
            Node node = q.poll();
            curr_size--;
            
            for(Node curr_child : node.children){
                q.add(curr_child);
            }
            
            level.add(node.val);
            if(curr_size == 0){
                ans.add(level);
                curr_size = q.size();
                level = new ArrayList<>();
            }            
        }
        
        
        return ans;
    }
}