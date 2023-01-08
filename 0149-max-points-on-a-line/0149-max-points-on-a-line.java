class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 1) return 1;
        int n = points.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                float slope = Float.MAX_VALUE;
                if(points[j][0] != points[i][0]){
                    slope = (float) (points[j][1] - points[i][1])/(points[j][0] - points[i][0]);
                }
                int pointsOnLine = 1;
                for(int k = 0; k < n; k++){
                    if(k == j) continue;
                    float currSl = Float.MAX_VALUE;
                    if(points[k][0] != points[j][0]){
                        currSl = (float) (points[k][1] - points[j][1])/(points[k][0] - points[j][0]);
                    }
                    if(currSl == slope) pointsOnLine++;
                }
                ans = Math.max(ans, pointsOnLine);
            }
            
        }
        
        return ans;
    }
}