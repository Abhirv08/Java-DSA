/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node root = new Node(node.val);
        HashMap<Integer, Node> map = new HashMap<>();
        
        map.put(root.val, root);
        cloneGraph(node, map);
        
        return root;
    }
    
    private void cloneGraph(Node node, HashMap<Integer, Node> map){
        
        for(Node neigh: node.neighbors){
            if(neigh == null) continue;
            int val = neigh.val;
            if(map.containsKey(val)){
                map.get(node.val).neighbors.add(map.get(val));
            }else{
                map.put(val, new Node(val));
                map.get(node.val).neighbors.add(map.get(val));
                cloneGraph(neigh, map);
            }
        }
        
    }
}