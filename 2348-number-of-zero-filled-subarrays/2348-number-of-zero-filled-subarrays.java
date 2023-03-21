class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int i = 0;
        
        while(i < n){
            long count = 0;
            boolean flag = false;
            while(i < n && nums[i] == 0){
                i++;
                count++;
                flag = true;
            }
            
            if(!flag) i++;
            ans += (count*(count+1))/2;
        }
        
        return ans;
    }
}