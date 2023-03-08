class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        //Arrays.sort(piles);
        for(int pile: piles){
            r = Math.max(r, pile);
        }
        

        while(l < r){
            int m = (l + r)/2;
            
            int hoursTaken = calculateHours(piles, m);

            if(hoursTaken <= h){
                r = m;
            }else{
                l = m + 1;
            }
        }
        
        return r;
    }
    
    int calculateHours(int[] piles, int speed){
        int hoursTaken = 0;
        
        for(int pile: piles){
            hoursTaken += pile/speed;
            if(pile%speed != 0) hoursTaken++;
        }
        
        return hoursTaken;
    }
}