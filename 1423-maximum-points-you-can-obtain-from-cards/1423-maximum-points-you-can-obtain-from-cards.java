class Solution {
    public int maxScore(int[] cp, int k) {
        
        int n = cp.length;
        
        int total_sum = 0;
        for(int num : cp){
            total_sum += num;
        }
        
        if(n == k){
            return total_sum;
        }
        
        int min_sum = Integer.MAX_VALUE;
        int sum = 0;
        int acq = 0;
        int rel = 0;
        int window_size = n - k;
        while(acq < n){
            sum += cp[acq];
            if(acq - rel + 1 < window_size){
                acq++;
            }else{
                if(sum < min_sum){
                    min_sum = sum;
                }
                sum -= cp[rel];
                rel++;
                acq++;
            }
        }
        
        return total_sum - min_sum;
    }
}