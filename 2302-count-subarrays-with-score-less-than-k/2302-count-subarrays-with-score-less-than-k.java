class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long sum = 0;
        long ans = 0;
        int acq = 0;
        int rel = 0;        
        while(acq < n){
            sum += nums[acq];    
                    
            while(sum*(acq-rel+1) >= k){
                sum -= nums[rel];
                rel++;
            }
            
            ans += (acq-rel+1);
            
            acq++;
        }
        return ans ;
    }
}