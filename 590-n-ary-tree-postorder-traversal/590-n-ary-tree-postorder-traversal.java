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
    public List<Integer> postorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        postOrder(root, answer);
        return answer;
    }
    
    static void postOrder(Node root, List<Integer> answer){
        if(root == null)
            return;
        
        for(Node currChild : root.children)
            postOrder(currChild, answer);
        
        answer.add(root.val);
        return;
    }
}