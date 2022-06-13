class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", ans);
        return ans;
    }
    
    private void generateParenthesis(int n, int op, int cp, String s, List<String> ans){
        if(op > n){
            return;
        }
        
        if(op == n && cp == n){
            ans.add(s);
            return;
        }
        
        if(op > cp){
            generateParenthesis(n, op+1, cp, s + "(", ans);
            generateParenthesis(n, op, cp+1, s + ")", ans);
        }
        
        if(op == cp){
            generateParenthesis(n, op+1, cp, s + "(", ans);
        }
        
        return;
    }
}