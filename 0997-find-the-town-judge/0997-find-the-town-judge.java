class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n > 1 && trust.length == 0) return -1;
        
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        
        for(int i = 0; i < trust.length; i++){
            indegree[trust[i][1] - 1]++;
            outdegree[trust[i][0] - 1]++;
        }
        
        int ans = -1;
        for(int i = 0; i < n; i++){
            if(indegree[i] == n-1 && outdegree[i] == 0)
                ans = i+1;
        }
        
        return ans;
    }
}