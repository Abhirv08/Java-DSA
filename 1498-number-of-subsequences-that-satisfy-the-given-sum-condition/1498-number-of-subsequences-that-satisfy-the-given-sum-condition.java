class Solution {
    int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int[] pow = new int[n];
        pow[0] = 1;
        for(int i = 1; i < n; i++){
            pow[i] = (pow[i-1]*2)%mod;
        }
        
        int s = 0, e = n - 1;
        int count = 0;
        while(s <= e){
            int sum = nums[s] + nums[e];
            if(sum <= target){
                count += pow[e-s];
                count %= mod;
                s++;
            }else{
                e--;
            }
        }
        
        return count;
    }
}