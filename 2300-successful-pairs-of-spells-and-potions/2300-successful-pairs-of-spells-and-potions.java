class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for(int i = 0; i < n; i++){
            ans[i] = findNumOfPotions(potions, spells[i], success);
        }
        return ans;
    }
    
    private int findNumOfPotions(int[] p, int spell, long success){
        int n = p.length;
        int start = 0;
        int end = n-1;        
        while(start < end){
            int mid = start + (end - start)/2;
            if((long) spell*p[mid] >= success){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        if((long)spell*p[start] < success){
            return n-1-start;
        }
        return n - start;
    }
}