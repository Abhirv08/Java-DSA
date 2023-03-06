class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        
        while(l <= r){
            int m = l + (r - l)/2;
            
            int num = arr[m];
            if(num == m + 1){
                l = m + 1;
            }else{
                int notAvailable = num - (m+1);
                if(k > notAvailable){
                    // k -= notAvailable;
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
        }
        
        if(r < 0) {
            return k;
        }
        
        k -= (arr[r] - (r+1));
        
        return arr[r] + k;
    }
}