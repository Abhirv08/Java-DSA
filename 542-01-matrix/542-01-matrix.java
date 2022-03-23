class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                    mat[i][j]=2;
                }
            }
        }
        
        int[][] ans = new int[n][m];
        int[][] dir = {{0,-1},{-1,0},{1,0},{0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] tup = q.poll();
                for(int i=0;i<4;i++){
                    int row = tup[0] + dir[i][0];
                    int col = tup[1] + dir[i][1];
                    if(row<0 || col<0 || row>=n || col>=m || mat[row][col]==2)
                        continue;
                    if(mat[row][col]==1){
                        ans[row][col] = tup[2]+1;
                    }
                    mat[row][col]=2;
                    q.offer(new int[]{row,col,ans[row][col]});
                }
            }
        }
        return ans;
    }
}