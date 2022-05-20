class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] memo = new int[k];
        for(int i = 0; i < arr.length; i++){
            int remainder = ((arr[i] % k)+k)%k;
            memo[remainder] += 1;
        }   
        for(int i = 0; i <= k/2; i++){
            if((memo[0]&1) == 1) return false;
            if(i > 0 && memo[i] != memo[k-i]){
                return false;
            }
        }
        return true;
    }    
    
}