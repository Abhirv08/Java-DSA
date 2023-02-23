class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        int[][] cmbnd = new int[n][2];
        
        for(int i = 0; i < n; i++){
            cmbnd[i][0] = capital[i];
            cmbnd[i][1] = profits[i];
        }
        
        Arrays.sort(cmbnd, (a,b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        if(cmbnd[0][0] > w) return 0;
        
        int i = 0;
        while(k-- > 0){
            while(i < n && cmbnd[i][0] <= w){
                pq.add(cmbnd[i][1]);
                i++;
            }
            
            if(pq.isEmpty()) break;
            else w += pq.poll();
        }
        
        return w;
    }
}