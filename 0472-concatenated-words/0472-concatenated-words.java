class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
                
        List<String> ans = new ArrayList<>();
        
        for(String word: words){
            int len = word.length();
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            for(int i = 1; i <= len; i++){
                for(int j = (i==len ? 1 : 0); !dp[i] && j < i; j++){
                    dp[i] = dp[j]&&set.contains(word.substring(j, i));
                }
            }
            if(dp[len]){
                ans.add(word);
            }
        }
        
        return ans;
    }
}