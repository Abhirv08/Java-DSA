class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] prev = new int[m], curr = new int[m];
        Arrays.fill(curr, 1000000);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < i+1; j++){
                if(i == 0 && j == 0) curr[j] = triangle.get(0).get(0);
                else if(i > 0){
                    int up = 1000000, left = 1000000;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = prev[j-1];
                    
                    curr[j] = triangle.get(i).get(j) + Math.min(up, left);
                }
            }
            prev = Arrays.copyOf(curr, m);
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            ans = Math.min(ans, curr[i]);
        }
        
        return ans;
    }
}