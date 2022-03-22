/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null;
        else
            return travers(root,root.next);
    }
    Node travers(Node root, Node next)
    {
        root.next=next;
        if(root.left!=null){
            root.left=travers(root.left,root.right);
            if(root.next!=null)
                root.right=travers(root.right,root.next.left);
            else                
                root.right=travers(root.right,root.next);
        }
        return root;
    }
}