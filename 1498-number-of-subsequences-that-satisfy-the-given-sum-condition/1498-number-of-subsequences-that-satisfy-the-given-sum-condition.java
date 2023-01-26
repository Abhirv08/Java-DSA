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
        for(int i = 0; i < n; i++){
            int countMax = binarySearch(nums, target - nums[i]);
            if(countMax < i) continue;
            else{
                ans = (long)((ans + pow[countMax - i])%mod);
            }
        }
        
        return (int)(ans%mod);
    }
    
    int binarySearch(int[] nums, int target){
         int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return end;
    }
}