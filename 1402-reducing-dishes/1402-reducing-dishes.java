class Solution {
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int n = s.length;
        
        int[] prefixSum = new int[n];
        prefixSum[n-1] = s[n-1];
        
        for(int i = n-2; i >= 0; i--){
            prefixSum[i] = prefixSum[i+1] + s[i];
        }
        
        // System.out.println(Arrays.toString(prefixSum));
        int ans = 0, curr = 0;
        
        for(int i = n-1; i >= 0 && curr >= ans; i--){
            curr += 1*s[i];
            if(i < n-1) curr += prefixSum[i+1];
            
            if(ans <= curr){
                ans = curr;
            }else{
                break;
            }           
        }
        
        return ans;
    }
}