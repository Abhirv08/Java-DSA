class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        if(piles.length == h){
            return piles[piles.length-1];
        }
        int left = 1;
        int right = piles[piles.length-1];
        while(left < right){
            int k = (right+left)/2;
            if(isOK(piles, k, h)){
               right = k; 
            }else{
                left = k+1;
            }
        }
        return right;
    }
    
    static boolean isOK(int[] piles,int k, int h){
        int hours_taken = 0;
        for(int i = 0; i< piles.length; i++){
            hours_taken += (int)(piles[i]+k-1)/k;
        }
        if(hours_taken <= h){
            return true;
        }
        return false;
    }
}