class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] pp = new int[n];
        pp[0] = 1;
        pp[1] = 2;
        int i = 2;
        while(i < n){
            pp[i] = pp[i-1]+pp[i-2];
            i++;
        }
        return pp[n-1];
    }

}