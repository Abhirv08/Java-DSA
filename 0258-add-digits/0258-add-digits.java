class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        
        int temp = num;
        int num2 = 0;
        while(num > 9){
            num2 += temp%10;
            temp /= 10;
            
            if(temp == 0){
                num = num2;
                temp = num;
                num2 = 0;
            }
        }
        
        return num;
    }
}