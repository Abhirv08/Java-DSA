/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        Node root = construct(n, grid, 0, n - 1, 0, n - 1);
        
        return root;
    }
    
    private Node construct(int n, int[][] grid, int sr, int er, int sc, int ec){
        if(sr == er && sc == ec) return new Node(grid[sr][sc] == 1, true);
        
        Node tl = construct(n, grid, sr, (sr+er)/2, sc, (sc + ec)/2);
        Node tr = construct(n, grid, sr, (sr+er)/2, (sc + ec)/2 + 1, ec);
        Node bl = construct(n, grid, (sr+er)/2 + 1, er, sc, (sc + ec)/2);
        Node br = construct(n, grid, (sr+er)/2 + 1, er, (sc + ec)/2 + 1, ec);
        
        if(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && tl.val == tr.val && tr.val == bl.val && bl.val == br.val){
            return new Node(tl.val, true);
        }
        
        return new Node(true, false, tl, tr, bl, br);
    }
}