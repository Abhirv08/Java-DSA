class Solution {
    public int smallestValue(int n) {
        int sum = n;
        while(true){
            int temp = 0;
            
            for(int i = 2; n > 1; ){
                if(n%i == 0){
                    temp += i;
                    n /= i;
                }else{
                    i++;
                }
            }
            if(sum == temp){
                break;
            }
            n = temp;
            
            if(sum == n){
                break;
            }else{
                sum = n;
            }
        }
        
        return sum;
    }
}