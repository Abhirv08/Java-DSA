class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 0, right = (int)1e9+1;
        // for(int num: nums){
        //     min = Math.min(min, num);
        //     max = Math.max(max, num);
        // }
        
        // System.out.println(max + " " + min);
        while(left < right){
            int mid = (left + right) >> 1;
            
            if(isPossible(nums, k, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean isPossible(int[] nums, int k, int capability){
        int lastTakenIndex = -2;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > capability || lastTakenIndex == i - 1) continue;
            count++;
            lastTakenIndex = i;
        }
        
        return count >= k;
    }
}