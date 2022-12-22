class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> edge: edges){
            int a = edge.get(0);
            int b = edge.get(1);
            
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        int oddDeg = 0;
        List<Integer> odds = new ArrayList<>();
        for(int i = 1; i < n + 1; i++){
            if(adj.get(i).size()%2 == 1){
                oddDeg++;
                odds.add(i);
            }
        }
        
        if(oddDeg == 0) return true;
        
        if(oddDeg == 2){
            int a = odds.get(0);
            int b = odds.get(1);
            
            if(!adj.get(a).contains(b)){
                return true;
            }
            
            for(int k = 1; k < n + 1; k++){
                if(!adj.get(k).contains(a) && !adj.get(k).contains(b)){
                    return true;
                }
            }
        }
        
        if(oddDeg == 4){
            int a = odds.get(0);
            int b = odds.get(1);
            int c = odds.get(2);
            int d = odds.get(3);
            
            if((!adj.get(a).contains(b) && !adj.get(c).contains(d)) 
               || (!adj.get(a).contains(c) && !adj.get(b).contains(d)) 
               || (!adj.get(b).contains(c) && !adj.get(a).contains(d))){
                return true;
            }            
        }
        
        return false;
    }
}