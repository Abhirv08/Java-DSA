class Solution {
    public int captureForts(int[] forts) {
        
        int ans = 0;
        for(int i = 0; i < forts.length; ){
            while(i < forts.length && forts[i] <= 0){
                i++;
            }
            
            if(i == forts.length) break;
            //while going left
            
            int j = i - 1;
            boolean flag = true;
            while(j >= 0 && forts[j] != -1){
                if(forts[j] == 1){
                    flag = false;
                    break;
                }
                j--;
            }
                
            if(j >= 0 && flag){
                ans = Math.max(i-j-1, ans);        
            }
            
            // while going right
            j = i + 1;
            flag = true;
            while(j < forts.length && forts[j] != -1){
                if(forts[j] == 1){
                    flag = false;
                    break;
                }
                j++;
            }
                
            if(j < forts.length && flag){
                ans = Math.max(j-i-1, ans);        
            }            
            
            i = j;
        }
        return ans;
    }
}