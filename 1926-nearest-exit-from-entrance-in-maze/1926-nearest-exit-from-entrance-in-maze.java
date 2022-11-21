class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1], 0});

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            int cs = curr[2];

            if(cr == rows - 1 || cc == cols - 1 || cr == 0 || cc == 0){
                if(cr == entrance[0] && cc == entrance[1]){
                }else{
                    return cs;
                }
            }

            for(int[] d: dir){
                int row = cr + d[0];
                int col = cc + d[1];

                if(row >= 0 && row < rows && col >= 0 && col < cols && maze[row][col] == '.'){
                    maze[row][col] = '+';
                    q.add(new int[]{row, col, cs+1});
                }
            }
        }

        return -1;
    }
}