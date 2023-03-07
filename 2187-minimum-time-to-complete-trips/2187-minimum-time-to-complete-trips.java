class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int maxTime = 0;
        for(int t: time) maxTime = Math.max(maxTime, t);
        
        long l = 1, r = (long) maxTime*totalTrips;
        
        while(l < r){
            long m = l + ( r - l)/2;
            
            long tripsDone = countTrips(time, m);
            
            if(tripsDone >= totalTrips){
                r = m;
            }else{
                l = m + 1;
            }
        }  
        
        return l;
    }
    
    long countTrips(int[] time, long currTime){
        long trips = 0;
        
        for(int i = 0; i < time.length; i++){
            trips += currTime/time[i];
        }
        
        return trips;
    }
}