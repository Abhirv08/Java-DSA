class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int max_reach = startFuel;
        int minStops = 0;
        
        for(int[] station : stations){
            int fuelAtStation = station[1];
            int nextStation = station[0];
            
            while(max_reach < nextStation){
                if(pq.isEmpty()) return -1;
                max_reach += pq.poll();
                minStops++;
            }
            
            pq.offer(fuelAtStation);
        }
        
        while(max_reach < target){
            if(pq.isEmpty()) return -1;
            max_reach += pq.poll();
            minStops++;
        }        
        
        return minStops;
    }
}