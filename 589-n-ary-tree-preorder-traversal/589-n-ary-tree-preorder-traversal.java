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
    public List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        preorderTraversal(root, answer);
        return answer;
    }
    
    static void preorderTraversal(Node root, List<Integer> answer){
        if(root == null)
            return;
        answer.add(root.val);
        List<Node> childrens = root.children;
        for(Node currChild : childrens){
            preorderTraversal(currChild, answer);
        }
        
        
        return;
    }
}