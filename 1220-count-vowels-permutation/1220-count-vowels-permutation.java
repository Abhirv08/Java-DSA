class Solution {
    int mod = (int)(1e9+7);
    public int countVowelPermutation(int n) {
        
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        getAdj(adj);
        
        int[][] dp = new int[5][n];
        
        for(int[] t : dp){
            Arrays.fill(t, -1);
        }
        
        int ans = 0;
        for(int i = 0; i < 5; i++){
            ans = (ans%mod + dfs(adj, i, n - 1, dp) % mod)%mod;
        }
        
        return ans%mod;
        
    }
    
    private int dfs(ArrayList<ArrayList<Integer>> adj, int currVwl, int n, int[][] dp){
        if(n == 0){
            return 1;
        }
        
        if(dp[currVwl][n] != -1){
            return dp[currVwl][n] % mod;
        }
        
        int ans = 0;
        for(int vwls : adj.get(currVwl)){
            ans = (ans%mod + dfs(adj, vwls, n - 1, dp)%mod)%mod;
        }
        
        return dp[currVwl][n] = ans%mod;
    }
    
    private void getAdj(ArrayList<ArrayList<Integer>> adj){
        for(int i = 0; i < 5; i++){
            adj.add(new ArrayList<>());
        }
        
        // for 'a'
        adj.get(getIndex('a')).add(getIndex('e'));
        
        // for 'e'
        adj.get(getIndex('e')).add(getIndex('a'));
        adj.get(getIndex('e')).add(getIndex('i'));
        
        // for 'i'
        adj.get(getIndex('i')).add(getIndex('a'));
        adj.get(getIndex('i')).add(getIndex('e'));
        adj.get(getIndex('i')).add(getIndex('o'));
        adj.get(getIndex('i')).add(getIndex('u'));
        
        // for 'o'
        adj.get(getIndex('o')).add(getIndex('i'));
        adj.get(getIndex('o')).add(getIndex('u'));
        
        // for 'u'
        adj.get(getIndex('u')).add(getIndex('a'));
        
    }
    
    private int getIndex(char ch){
        switch(ch){
            case 'a' : return 0;
            case 'e' : return 1;
            case 'i' : return 2;
            case 'o' : return 3;
            case 'u' : return 4;
            default : return 5;
        }
    }
}