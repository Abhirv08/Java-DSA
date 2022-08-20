class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans = Integer.MAX_VALUE;
        
        int whiteColor = 0;
        for(int acq = 0, rel = 0; acq < blocks.length();){
            if(blocks.charAt(acq) == 'W') whiteColor++;
            
            if(acq - rel + 1 < k){
                acq++;
            }else{
                ans = Math.min(ans, whiteColor);
                if(blocks.charAt(rel) == 'W') whiteColor--;
                rel++;
                acq++;
            }
        }
        
        return ans;
    }
}