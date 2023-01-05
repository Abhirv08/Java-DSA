class Solution {
    public int findMinArrowShots(int[][] x) {
        
        Arrays.sort(x, (a,b) -> Integer.compare(a[1], b[1]));
        
        int ans = 1;
        int point = x[0][1];
        
        for(int i = 1; i < x.length; i++){
            if(x[i][0] <= point){
                continue;
            }else{
                ans++;
                point = x[i][1];
            }
        }
        
        return ans;
    }
}