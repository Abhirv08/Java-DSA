class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long[] ps = new long[n];
        ps[0] = nums[0];
        int mx = nums[0];
        for(int i = 1; i < n; i++){
            ps[i] = ps[i-1] + nums[i];
            mx = Math.max(mx, nums[i]);
        }
        
        long l = 1, r = mx;
        
        long ans = 0;
        while(l <= r){
            long m = (long) (r+l)/2;
            
            int i = 0;
            for(; i < n; i++){
                if(nums[i] < 1) continue;
                long iv = (i+1)*m;
                if(iv < ps[i]) break;
            }
            
            if(i < n) l = m + 1;
            else{
                ans = m;
                r = m - 1;
            }
        }
        
        return (int) ans;
    }
}