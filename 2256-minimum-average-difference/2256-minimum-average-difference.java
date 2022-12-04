// class Solution {
//     public int minimumAverageDifference(int[] nums) {
//         int n = nums.length;
        
//         int[] prefixSum = new int[n];
//         prefixSum[0] = nums[0];
//         for(int i = 1; i < n; i++){
//             prefixSum[i] = prefixSum[i-1] + nums[i];
//         }
        
//         int[] suffixSum = new int[n];
//         suffixSum[n-1] = 0;
//         for(int i = n - 2; i >= 0; i--){
//             suffixSum[i] = suffixSum[i+1] + nums[i];
//         }
        
//         int minDiff = Integer.MAX_VALUE;
//         int ans = 0;
        
//         for(int i = 0; i < n; i++){
//             long prevAvg = prefixSum[i]/(i+1);
//             long nextAvg = 0;
//             if(n-1-i > 0){
//                 nextAvg = suffixSum[i]/(n-1-i);
//             }
            
//             int absDiff = (int)Math.abs(prevAvg - nextAvg);

//             if(absDiff < minDiff){
//                 minDiff = absDiff;
//                 ans = i;
//             }
//         }
        
//         return ans;
//     }
// }

class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int minAvgDiff = Integer.MAX_VALUE;
        
        // Generate prefix and suffix sum arrays.
        long[] prefixSum = new long[n + 1];
        long[] suffixSum = new long[n + 1];
        
        for (int index = 0; index < n; ++index) {
            prefixSum[index + 1] = prefixSum[index] + nums[index];
        }
        
        for (int index = n - 1; index >= 0; --index) {
            suffixSum[index] = suffixSum[index + 1] + nums[index];
        }
        
        for (int index = 0; index < n; ++index) {
            // Calculate average of left part of array, index 0 to i.
            long leftPartAverage = prefixSum[index + 1];
            leftPartAverage /= (index + 1);
            
            // Calculate average of right part of array, index i+1 to n-1.
            long rightPartAverage = suffixSum[index + 1];
            // If right part have 0 elements, then we don't divide by 0.
            if (index != n - 1) {
                rightPartAverage /= (n - index - 1);
            }
            
            int currDifference = (int) Math.abs(leftPartAverage - rightPartAverage);
            // If current difference of averages is smaller,
            // then current index can be our answer.
            if (currDifference < minAvgDiff) {
                minAvgDiff = currDifference;
                ans = index;
            }
        }
        
        return ans;
    }
}