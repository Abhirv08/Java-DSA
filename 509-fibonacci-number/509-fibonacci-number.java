class Solution {
    public int fib(int n) {
//         if(n < 2){
//             return n;
//         }
        
//         return fib(n - 1) + fib(n - 2);
        
        return fib(n, new HashMap<>());
    }
    
    private int fib(int n, HashMap<Integer, Integer> memo){
        if(n < 2){
            return n;
        }
        
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        
        int left = fib(n - 1);
        int right = fib(n - 2);
        
        memo.put(n, left + right);
        
        return left+right;
    }
}