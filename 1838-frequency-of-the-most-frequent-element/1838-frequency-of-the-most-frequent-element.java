class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        
        int ans=0;
        long sum=0;
        int l=0,r=0;
        
        while(r<nums.length){
            sum+=nums[r];
            
            while(nums[r]*(r-l+1)>sum+k){
                sum-=nums[l];
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}