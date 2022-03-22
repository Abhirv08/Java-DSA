class Solution {
    public String getSmallestString(int n, int k) {
        char[] ansArr = new char[n];
        Arrays.fill(ansArr, 'a');
        k = k - n;
        while(k > 0){
            ansArr[--n] += Math.min(25, k);
            k -= Math.min(25, k);
        }
        
        
        return String.valueOf(ansArr);
    }
}