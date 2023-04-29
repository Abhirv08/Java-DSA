class UF {
    private int[] rank;
    private int[] group;
    
    public UF(int n){
        this.rank = new int[n];
        this.group = new int[n];
        for(int i = 0; i < n; i++){
            group[i] = i;
        }
    }
    
    public void join(int node1, int node2){
        int g1 = find(node1);
        int g2 = find(node2);
        
        if(g1 == g2){
            return ;
        }
        
        if(rank[g1] > rank[g2]){
            group[g2] = g1;
        }else if(rank[g1] < rank[g2]){
            group[g1] = g2;
        }else{
            group[g2] = g1;
            rank[g1]++;
        }
    }
    
    public boolean areConnected(int node1, int node2){
        int g1 = find(node1);
        int g2 = find(node2);
        
        return g1 == g2;
    }
    
    private int find(int node){
        if(group[node] != node){
            group[node] = find(group[node]);
        }
        
        return group[node];
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int qCount = queries.length;
        int[][] queries_new = new int[qCount][4];
        for(int i = 0; i < qCount; i++){
            queries_new[i][0] = queries[i][0];
            queries_new[i][1] = queries[i][1];
            queries_new[i][2] = queries[i][2];            
            queries_new[i][3] = i;
        }
        Arrays.sort(queries_new, (a,b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a,b) -> a[2] - b[2]);
        boolean[] ans = new boolean[qCount];
        
        List<List<int[]>> adj = new ArrayList<>();
        int edgeIndex = 0;
        
        UF uf = new UF(n);
        for(int[] q: queries_new){
            int n1 = q[0], n2 = q[1];
            int limit = q[2], org_idx = q[3];
            
            while(edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit){
                uf.join(edgeList[edgeIndex][0], edgeList[edgeIndex][1]);
                edgeIndex++;
            }
            
            if(uf.areConnected(n1, n2)){
                ans[org_idx] = true;
            }
        }
        
        return ans;
    }
}