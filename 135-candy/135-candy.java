class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        int[] relativeToLeft = new int[n];
        relativeToLeft[0] = 1;
        
        for(int i = 1; i< n; i++){
            if(ratings[i - 1] < ratings[i]){
                relativeToLeft[i] = relativeToLeft[i-1]+1;
            }else{
                relativeToLeft[i] = 1;
            }
        }
        
        int[] relativeToRight = new int[n];
        relativeToRight[n-1] = 1;
        
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i + 1] < ratings[i]){
                relativeToRight[i] = relativeToRight[i+1]+1;
            }else{
                relativeToRight[i] = 1;
            }
        }
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            ans += Math.max(relativeToRight[i], relativeToLeft[i]);
        }
        
        return ans;
    }
}