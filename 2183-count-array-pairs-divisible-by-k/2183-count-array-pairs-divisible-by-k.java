class Solution {
    public long countPairs(int[] nums, int k) {
//         long ans = 0;
//         int n = nums.length;
//         HashMap<Integer, Integer> memo = new HashMap<>();
//         for(int i = 0; i < n; i++){
//             int gcd1 = findGCD(nums[i], k);
            
//             for(int gcd2 : memo.keySet()){
//                 if( (long)(gcd1*gcd2) % k == 0 ){
//                     ans += memo.get(gcd2);
//                 }
//             }
            
//             if(memo.containsKey(gcd1)){
//                 memo.put(gcd1, memo.get(gcd1) + 1);
//             }else{
//                 memo.put(gcd1, 1);
//             }
//         }
        
//         return ans;
        
        
        long result = 0;
        Map<Integer, Integer> gcdMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gcd = findGcd(nums[i], k);
            for (int num : gcdMap.keySet()) {
                if ((long) gcd * num % k == 0) { // Need to convert gcd(i) * gcd(j) to long, sad java
                    result += gcdMap.get(num);
                }
            }
            gcdMap.put(gcd, gcdMap.getOrDefault(gcd, 0) + 1);
        }
        return result;
    }
    
    private int findGcd(int x, int y) {
        if (x < y) {
            return findGcd(y, x);
        }
        return y == 0 ? x : findGcd(y, x % y);
    }
}
