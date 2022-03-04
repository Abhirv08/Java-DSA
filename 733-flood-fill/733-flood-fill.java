class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        int givenColor = image[sr][sc];
        image[sr][sc] = newColor;        
        helping(image, sr, sc, newColor, givenColor);
        return image;
    }
    
    static void helping(int[][] mat, int sr, int sc, int newColor, int givenColor){
        if(sr-1 >= 0 && mat[sr-1][sc]==givenColor){
            mat[sr-1][sc] = newColor;
            helping(mat, sr-1, sc, newColor, givenColor);
        }
        if(sc+1 < mat[0].length && mat[sr][sc+1]==givenColor){
            mat[sr][sc+1] = newColor;
            helping(mat, sr, sc+1, newColor, givenColor);            
        }
        if(sr+1 < mat.length && mat[sr+1][sc]==givenColor){
            mat[sr+1][sc] = newColor;
            helping(mat, sr+1, sc, newColor, givenColor);
        }
        if(sc-1 >= 0 && mat[sr][sc-1]==givenColor){
            mat[sr][sc-1] = newColor;
            helping(mat, sr, sc-1, newColor, givenColor);            
        }
        return;
    }
}