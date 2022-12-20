class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()){
            int currRoom = q.poll();
            vis[currRoom] = true;
            
            for(int room: rooms.get(currRoom)){
                if(!vis[room]){
                    q.add(room);
                }
            }
        }
        
        for(boolean visited: vis){
            if(!visited){
                return false;
            }
        }
        
        return true;
    }
}