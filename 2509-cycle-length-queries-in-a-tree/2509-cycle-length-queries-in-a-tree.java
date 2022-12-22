class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        
        
        for(int i = 0; i < m; i++){
            ans[i] = findCycleLength(queries[i][0], queries[i][1]);
        }
        
        return ans;
    }
    
    private int findCycleLength(int left, int right){
        int x = 0, y = 0;
        
        while(left != right){
            if(left > right){
                left /= 2;
                x++;
            }else if(right > left){
                right /= 2;
                y++;
            }
        }
        
        return x+y+1;
    }
}