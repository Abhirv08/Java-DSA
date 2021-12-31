class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int count = 0;
        // while(temp > 0){
        //     if((temp & 1) ==1){
        //         count++;
        //     }
        //     temp = temp >> 1;
        // }
        
        while(temp > 0){
            temp = temp & (temp-1);
            count++;
        }
        
        return count;
    }
}