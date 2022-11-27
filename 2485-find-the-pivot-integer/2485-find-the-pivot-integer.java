class Solution {
    public int pivotInteger(int n) {
        if(n == 1) return 1;
        
        int sum = (n*(n+1))>>1;
        for(int i = 1; i <= n; i++){
            int prevSum = (i*(i+1))>>1;
            int nextSum = sum - prevSum + i;
            
            if(prevSum == nextSum) return i;
        }
        
        return -1;
    }
}