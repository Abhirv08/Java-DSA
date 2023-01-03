class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = nums1[i] - nums2[i];
        }
        
        return divideAndConquer(nums, diff, 0, n-1);
    }
    
    private long divideAndConquer(int[] nums, int diff, int l, int r){
        if(l == r){        
            return 0;        
        }
        
        int mid = l + (r-l)/2;
        long left = divideAndConquer(nums, diff, l, mid);
        long right = divideAndConquer(nums, diff, mid+1, r);
        
        int[] leftArr = new int[mid-l+1];
        for(int i = 0; i < mid-l+1; i++){
            leftArr[i] = nums[l+i];
        }
        int[] rightArr = new int[r - mid];
        for(int i = 0; i < r-mid; i++){
            rightArr[i] = nums[mid+1+i];
        }
        
        Arrays.sort(leftArr);
        long ans = 0;
        for(int i = 0; i < rightArr.length; i++){
            ans += bs(leftArr, diff+rightArr[i]);
        }
        
        return ans + left + right;
    }
    
    private long bs(int[] arr, int target){
        int l = 0, r = arr.length - 1;
        
        while(l <= r){
            int mid = l + (r-l)/2;
            if(arr[mid] <= target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        
        return r+1;
    }
}