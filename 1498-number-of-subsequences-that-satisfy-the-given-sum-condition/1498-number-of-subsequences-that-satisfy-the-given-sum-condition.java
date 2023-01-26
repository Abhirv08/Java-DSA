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
        
        int i = 0, j = n - 1;
        long ans = 0;
        while(i <= j){
            if(nums[i] + nums[j] <= target){
                ans = (ans + pow[j-i])%mod;
                    i++;
            }else{
                j--;
            }
        }
        
        return (int)(ans%mod);
    }
}