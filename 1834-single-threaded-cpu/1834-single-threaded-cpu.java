class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];
        
        for(int i = 0; i < n; i++){
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        
        Arrays.sort(sortedTasks, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );
        
        int time = sortedTasks[0][0];
        int[] ans = new int[n];
        int j = 0;
        for(int i = 0; i < n; ){
            while(i < n && sortedTasks[i][0] <= time){
                pq.add(new int[]{sortedTasks[i][1], sortedTasks[i][2]});
                i++;
            }
            
            if(pq.isEmpty()){
                if(i < n) time = sortedTasks[i][0];
            }else{
                time += pq.peek()[0];
                ans[j++] = pq.peek()[1];
                pq.poll();
            }            
        }
        
        while(!pq.isEmpty()){
            ans[j++] = pq.peek()[1];
            pq.poll();
        }
        
        return ans;
    }
}