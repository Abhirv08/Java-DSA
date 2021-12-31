// 476. Number Complement
// The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

//For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.

class Solution {
    public int findComplement(int num) {
    int finalAns = 0;
        int count = 0;      
        while(num > 0){
            if((num&1) == 0){
                finalAns += (int)(Math.pow(2, count));                
            }
            count++;
            num= num >> 1;
        }
        return finalAns;
    }    
}