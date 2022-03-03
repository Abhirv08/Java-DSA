class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i =0; i<= n; i++){
            arr[i] = hammingWeight(i);
        }
        return arr;
    }
    
    static int hammingWeight(int n) {
        int no_of_one = 0;
        while(n>0){
            no_of_one++;
            n -= (n&(-n));
        }
        return no_of_one ;
    }
}