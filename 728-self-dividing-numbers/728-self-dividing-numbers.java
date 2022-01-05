class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        while(left <= right){
            if(isSelfDriving(left)){
                ans.add(left);                
            }
            left++;
        }
        return ans;
    }
    
    static boolean isSelfDriving(int n){
        int original_num = n;
        while(n>0){
            int remainder = n % 10;
            if(remainder == 0 || original_num % remainder != 0 ){
               return false;
            }
            n/=10;
        }
        return true;
    }
}