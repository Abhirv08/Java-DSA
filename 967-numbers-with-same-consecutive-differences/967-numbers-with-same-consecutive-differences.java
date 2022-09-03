class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 1; i < 10; i++){
            findNums(n-1, k, i, list);
        }
        
        int[] ans = new int[list.size()];
        
        int i = 0;
        for(int num: list){
            ans[i] = num;
            i++;
        }
        
        return ans;
    }
    
    private void findNums(int n, int k, int num, ArrayList<Integer> list){
        if(n == 0){
            list.add(num);
            return;
        }
        
        for(int i = 0; i < 10; i++){
            int ld = num%10;
            if(Math.abs(ld - i) == k){
                findNums(n-1, k, num*10 + i, list);
            }
        }        
        
    }
}