class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int rowStart = 0;
        int rowEnd = m-1;
        if(m==1){
            return new int[]{0, searchMaxIndex(mat[0], n-1)};
        }
        while(rowStart <= rowEnd){
            int midRow = rowStart + (rowEnd - rowStart)/2;
            int maxIndex = searchMaxIndex(mat[midRow], n-1);         
            
            if(midRow==0){
                if(mat[midRow][maxIndex] > mat[midRow+1][maxIndex]){
                    return new int[]{midRow, maxIndex};
                }else{
                    rowStart = midRow + 1;
                }                
            }else if(midRow == m-1){
                if(mat[midRow][maxIndex] > mat[midRow-1][maxIndex]){
                    return new int[]{midRow, maxIndex};
                }else{
                    rowEnd = midRow - 1;
                }                
            }else{
                if(mat[midRow][maxIndex] > mat[midRow + 1][maxIndex] && mat[midRow][maxIndex] > mat[midRow - 1][maxIndex]){
                    return new int[]{midRow, maxIndex};
                }else if(mat[midRow][maxIndex] < mat[midRow + 1][maxIndex] && mat[midRow][maxIndex] > mat[midRow - 1][maxIndex]){
                    rowStart = midRow + 1;
                }else{
                    rowEnd = midRow - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    static int searchMaxIndex(int[] arr, int end){
        int maxIndex = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[maxIndex] < arr[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}