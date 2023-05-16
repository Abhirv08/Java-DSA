class Solution {
    int[] cache;
    public int maxScore(int[] nums) {        
        cache = new int[(1 << nums.length)];
        Arrays.fill(cache, -1);
        return maxScore(nums, 0, 1);
    }
    
    private int maxScore(int[] nums, int mask, int op){   
        if(cache[mask] != -1) return cache[mask];
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(((1 << i) & mask) > 0) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(((1 << j) & mask) > 0) continue;
                
                int newMask = mask | (1 << i) | (1 << j);
                int score = op*getGCD(nums[i], nums[j]) + maxScore(nums, newMask, op+1);
                max = Math.max(max, score);
            }
        }        
        
        return cache[mask] = max;
    }
    
    private int getGCD(int a, int b){
        if(b == 0) return a;
        
        return getGCD(b, a%b);
    }
}