class Pair{
    int vertex;
    long time;
    
    public Pair(int vertex, long time){
        this.vertex = vertex;
        this.time = time;
    }
}
class Solution {
    int mod = 1000000007;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] road: roads){
            adj.get(road[1]).add(new int[]{road[0], road[2]});
            adj.get(road[0]).add(new int[]{road[1], road[2]});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.time, b.time));
        pq.add(new Pair(0, 0));
        long[] ways = new long[n];
        ways[0] = 1l;
        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.remove();  
                       
            for(int[] neigh: adj.get(p.vertex)){
                long newTime = p.time + neigh[1];
                if(time[neigh[0]] > newTime){
                    time[neigh[0]] = newTime;
                    ways[neigh[0]] = ways[p.vertex]%mod;
                    pq.add(new Pair(neigh[0], newTime));
                }else if(time[neigh[0]] == newTime){                    
                    ways[neigh[0]] = (ways[neigh[0]] + ways[p.vertex]%mod)%mod;
                }
            }
        }
        
        //System.out.println(Arrays.toString(ways));
        
        return (int)(ways[n-1]%mod);
    }    
}