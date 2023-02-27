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
        if(checkValues(grid, n, sr, er, sc, ec)) return new Node(grid[sr][sc] == 1, true);
        
        Node root = new Node(true, false);
        
        root.topLeft = construct(n, grid, sr, (sr+er)/2, sc, (sc + ec)/2);
        root.topRight = construct(n, grid, sr, (sr+er)/2, (sc + ec)/2 + 1, ec);
        root.bottomLeft = construct(n, grid, (sr+er)/2 + 1, er, sc, (sc + ec)/2);
        root.bottomRight = construct(n, grid, (sr+er)/2 + 1, er, (sc + ec)/2 + 1, ec);
        
        return root;
    }
    
    private boolean checkValues(int[][] grid, int n, int sr, int er, int sc, int ec){
        
        for(int i = sr; i <= er; i++){
            for(int j = sc; j <= ec; j++){
                if(grid[i][j] != grid[sr][sc]) return false;
            }
        }
        
        return true;
    }
}