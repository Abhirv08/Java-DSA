class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uc1, int uc2) {
        long l = 2L, r = 10000000000L;
        
        long div1 = (long)divisor1;
        long div2 = (long)divisor2;
        long div3 = (div1*div2)/gcd(div1, div2);
        
        int ans = 0;
        while(l <= r){
            long mid = (l + r)/2;
            
            long a = mid - (mid/div1);
            long b = mid - (mid/div2);
            long c = mid - (mid/div1) - (mid/div2) + (mid/div3);
            
            if(a >= uc1 && b >= uc2 && a+b-c >= (uc1+uc2)){
                ans = (int)mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        
        return ans;
    }
    
    private long gcd(long num1, long num2){
        if(num1 == 0) return num2;
        if(num2 == 0) return num1;
        
        return gcd(num2, num1%num2);
    }
}