class Solution {
    int mod = (int)(1e9+7);
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        
        HashMap<Integer, Long> memo = new HashMap<>();
        memo.put(arr[0], 1l);
        
        for(int i = 1; i < n; i++){
            long count = 1;
            for(Map.Entry<Integer,Long> e : memo.entrySet()){
                int num = e.getKey();
                
                if(arr[i]%num == 0 && memo.containsKey(arr[i]/num)){
                    count += (memo.get(num)%mod * memo.get(arr[i]/num)%mod)%mod;
                }
                
            }
            
            memo.put(arr[i], count);
        }
        long ans = 0;
        
        for(Map.Entry<Integer,Long> e : memo.entrySet()){
            ans += e.getValue()% mod;
                
        }
        
        return (int)(ans % mod);
    }
}