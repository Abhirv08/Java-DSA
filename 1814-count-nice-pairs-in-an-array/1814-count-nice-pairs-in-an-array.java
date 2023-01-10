class Solution {
    int mod = 1000000007;
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums){
            int rev = getReverse(num);
            int key = num - rev;
            
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        long ans = 0;
        for(int value: map.values()){
            long val = value;
            ans = (ans + (val*(val-1))/2);
        }
        
        return (int)(ans%mod);
    }
    
    private int getReverse(int num){
        int ans = 0;
        while(num > 0){
            ans = ans*10 + num%10;
            
            num/=10;
        }
        
        return ans;
    }
    
}