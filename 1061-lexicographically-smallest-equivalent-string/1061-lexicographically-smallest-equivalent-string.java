class Solution {
    int[] parent;
    private void update(char ch1, char ch2){
        int p1 = findParent(ch1 - 'a');
        int p2 = findParent(ch2 - 'a');
        
        if(p1 == p2) return ;
        if(p1 < p2){
            parent[p2] = p1;
        }else{
            parent[p1] = p2;
        }
        
        return ;        
    }
    
    private int findParent(int idx){
        if(idx == parent[idx]) return idx;
        
        return parent[idx] = findParent(parent[idx]);
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];
        for(int i = 0; i < 26; i++){
            parent[i] = i;
        }
        int n = s1.length();
        for(int i = 0 ; i < n; i++){
            update(s1.charAt(i), s2.charAt(i));
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < baseStr.length(); i++){
            int par = findParent(baseStr.charAt(i) - 'a');
            ans.append((char)(par + 'a'));
        }
        
        return ans.toString();
    }
}