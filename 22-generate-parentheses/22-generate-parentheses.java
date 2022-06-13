class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", ans);
        return ans;
    }
    
    private void generateParenthesis(int n, int op, int cp, String s, List<String> ans){
        
        
        if(op == n && cp == n){
            ans.add(s);
            return;
        }
        
        if(op < n){
            generateParenthesis(n, op+1, cp, s+"(", ans);
        }
        
        if(op > cp)
            generateParenthesis(n, op, cp+1, s + ")", ans);
        
        return;
    }
}