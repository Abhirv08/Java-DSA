class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while(i < matrix.length){
            if(matrix[i][j] >= target){
                return search( matrix[i], target);
            }else{
                i++;
            }
        }
        return false;
    }
    
    static boolean search(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == arr[mid]){
                return true;
            }else if(arr[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
}