class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor == image[sr][sc]) return image;
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void fill(int[][] image, int currentRow, int currentCol, int newColor, int givenColor){
        if(currentRow < 0 || currentRow >= image.length || currentCol < 0 || currentCol >= image[0].length || image[currentRow][currentCol] != givenColor){
            return;
        }
        
        image[currentRow][currentCol] = newColor;
        
        fill(image, currentRow - 1, currentCol, newColor, givenColor);
        fill(image, currentRow + 1, currentCol, newColor, givenColor);
        fill(image, currentRow, currentCol - 1, newColor, givenColor);
        fill(image, currentRow, currentCol + 1, newColor, givenColor);
        
        return;
    }
}