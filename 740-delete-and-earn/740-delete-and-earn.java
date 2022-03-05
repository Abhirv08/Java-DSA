class Solution {
    public int deleteAndEarn(int[] nums) {
        int inc = 0;
        int exc = 0;
        
        int[] freq = new int[10001];
        
        for(int val:nums){
            freq[val]++;
        }
        
        for(int i = 0; i <= 10000; i++){
            int nInc = exc + freq[i]*i;
            int nExc = Math.max(inc, exc);
            
            inc = nInc;
            exc = nExc;
        }
        
        return Math.max(inc, exc);
    }
}