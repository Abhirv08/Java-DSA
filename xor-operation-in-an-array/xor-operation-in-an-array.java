class Solution {
    public int xorOperation(int n, int start) {
        int i = 0;
        int num = 0;
        while(i < n){
            num ^= ( start + 2*i );
            i++;
        }
        return num;
    }
}