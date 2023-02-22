class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0, maxLoad = 0;
        
        for(int weight: weights){
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }
        
        int l = maxLoad, r = totalLoad;
        while(l < r){
            int m = (r + l)/2;            
            
            if(!findDaysToShip(weights, m, days)){
                l = m + 1;
            }else{
                r = m;
            }
        }
        
        return l;
    }
    
    private boolean findDaysToShip(int[] weights, int weight, int days){
        int daysNeeded = 1;
        int n = weights.length;       
        
        int currWeight = 0;
        for(int i = 0; i < n; i++){
            currWeight += weights[i];
            if(currWeight > weight){
                currWeight = weights[i];
                daysNeeded++;
            }
        }
        
        return daysNeeded <= days;
    }
}