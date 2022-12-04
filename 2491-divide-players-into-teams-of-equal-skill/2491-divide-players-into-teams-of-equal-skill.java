class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        
        int score = skill[n-1] + skill[0];
        long ans = 0;
        
       int i = 0, j = n - 1;
        while(i < j){
            int currscore = skill[j] + skill[i];
            if(currscore == score){
                ans += skill[i]*skill[j];
            }else{
                return -1;
            }
            i++;
            j--;
        }
        
        return ans;
    }
}