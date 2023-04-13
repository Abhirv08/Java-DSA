class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] arr = new int[n];
        int[] len = new int[n];
        Arrays.fill(arr, 1);
        Arrays.fill(len, 1);
        
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(arr[j] + 1 == arr[i]){
                        len[i] += len[j];
                    }else if(arr[j] + 1 > arr[i]){
                        arr[i] = arr[j] + 1;
                        len[i] = len[j];
                    }                    
                }
            }
            max = Math.max(max, arr[i]);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == max){
                count += len[i];
            }
        }
        
        return count;
    }
}