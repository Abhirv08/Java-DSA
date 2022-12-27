class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int ar) {
        int n = capacity.length;
        int[] req = new int[n];
        int alreadyFull = 0;
        for(int i = 0; i < n; i++){
            req[i] = capacity[i] - rocks[i]; 
            if(req[i] == 0){
                alreadyFull++;
            }
        }
        
        Arrays.sort(req);
        int fullBags = 0;
        
        for(int i = 0; i < n && ar > 0; i++){
            if(req[i] == 0) continue;
            if(req[i] <= ar){
                fullBags++;
                ar -= req[i];
            }
        }
        
        return fullBags+alreadyFull;
    }
}