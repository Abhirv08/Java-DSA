class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] initials = new HashSet[26];
        for(int i = 0; i < 26; i++){
            initials[i] = new HashSet<>();
        }
        for(String word: ideas){
            char ch = word.charAt(0);
            initials[ch - 'a'].add(word.substring(1));
        }
        
        return totalNames(initials);
    }
    
    long totalNames(Set<String>[] initials){
        long ans = 0;
        
        for(int i = 0; i < 25; i++){
            for(int j = i + 1; j < 26; j++){
                long sameSuffix = 0;
                for(String suf: initials[i]){
                    if(initials[j].contains(suf)){
                        sameSuffix++;
                    }
                }
                
                ans += 2*(initials[i].size() - sameSuffix)*(initials[j].size() - sameSuffix);
            }
        }
        
        return ans;
    }
}