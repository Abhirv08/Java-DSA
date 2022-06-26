class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int sum1 = 0; int sum2 = 0;
        
        for(int i = 0; i < n; i++){
            sum1 += nums1[i];
            sum2 += nums2[i];
        }
        
        int[] diffArr1 = new int[n];
        int[] diffArr2 = new int[n];
        for(int i = 0; i < n; i++){
            diffArr1[i] = nums2[i] - nums1[i];
            diffArr2[i] = nums1[i] - nums2[i];
        }
        
        int maxSubArray1 = findMaxSubArray(diffArr1);
        int maxSubArray2 = findMaxSubArray(diffArr2);
        
        return (sum1 + maxSubArray1) > (sum2 + maxSubArray2) ? (sum1 + maxSubArray1) : (sum2 + maxSubArray2);  
        
    }
    
    private int findMaxSubArray(int[] nums){
        int max_sum_till_now = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for(int num : nums){
            currentSum += num;
            
            if(currentSum > max_sum_till_now){
                max_sum_till_now = currentSum;
            }
            
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        
        return max_sum_till_now;
    }
}