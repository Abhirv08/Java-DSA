class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        int n = nums.length;
        Arrays.sort(nums);
        
        int[] pow = new int[n];
        pow[0] = 1;
        for(int i = 1; i < n; i++){
            pow[i] = (pow[i-1]*2)%mod;
        }

        long ans = 0;
        int r = n - 1;
        
        for(int i = 0; i < n; i++){
            while(r >= 0 && nums[i] + nums[r] > target && i <= r) r--;
            
            if(i <= r){
                ans = (ans + pow[r-i])%mod;
            }
        }
        
        return (int)(ans%mod);
    }
}