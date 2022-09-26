class Solution {
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        for(int i = 0; i < 26; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(String equation: equations){
            if(equation.charAt(1) == '='){
                int var1 = equation.charAt(0) - 'a';
                int var2 = equation.charAt(3) - 'a';
                
                unite(var1, var2);
            }
        }
        
        for(String equation: equations){
            if(equation.charAt(1) == '!'){
                int var1 = equation.charAt(0) - 'a';
                int var2 = equation.charAt(3) - 'a';
                
                if(isParent(var1, var2)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isParent(int a, int b){
        a = findPar(a);
        b = findPar(b);
        
        return a == b;
    }
    
    private int findPar(int n){
        if(parent[n] == n){
            return n;
        }
        
        return parent[n] = findPar(parent[n]);
    }
    
    private void unite(int a, int b){
        a = findPar(a);
        b = findPar(b);
        
        if(a == b) return;
        
        if(rank[a] > rank[b]){
            parent[b] = a;
        }else if(rank[a] < rank[b]){
            parent[a] = b;
        }else{
            parent[b] = a;
            rank[a]++;
        }
        
        return; 
    }
    
    
}