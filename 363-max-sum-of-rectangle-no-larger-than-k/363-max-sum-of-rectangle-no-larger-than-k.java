class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        
        for(int row = 0; row < rows; row++){
            int[] windowSum = new int[cols];
            for(int rowsupto = row; rowsupto < rows; rowsupto++){
                for(int col = 0; col < cols; col++){
                    windowSum[col] += matrix[rowsupto][col];
                }                
                ans = Math.max(ans, find(windowSum, k));
            }
        }        
        
        return ans;
    }
    
    private int find(int[] arr, int k){
        TreeSet<Integer> set = new TreeSet<>();
        int result = Integer.MIN_VALUE;
        set.add(0);
        
        int prefixSum = 0;
        
        for(int num : arr){
            prefixSum += num;
            
            Integer target = set.ceiling(prefixSum - k);
            
            if(target != null){
                result = Math.max(result, prefixSum - target);
            }
            
            set.add(prefixSum);
        }
        
        return result;        
    }
    
}