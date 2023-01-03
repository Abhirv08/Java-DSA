class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(toBeDeleted(strs, i)){
                ans++;
            }
        }
        
        return ans;
    }
    
    private boolean toBeDeleted(String[] strs, int col){
        for(int i = 1; i < strs.length; i++){
            char prev = strs[i-1].charAt(col);
            char curr = strs[i].charAt(col);
            
            if(curr - prev < 0) return true;
        }
        
        return false;
    }
}