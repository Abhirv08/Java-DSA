class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        int min = gcd(m,n);
        
        if(m == n && min == m){
            return str1.equals(str2) ? str1: "";
        }
        
        String t = str1.substring(0, min);        
        
        for(int i = 0; i < m; i += min){
            if(!t.equals(str1.substring(i, i+min))){
                return "";
            }
        }
        
        for(int i = 0; i < n; i += min){
            if(!t.equals(str2.substring(i, i+min))){
                return "";
            }
        }
        
        return t;
    }
    
    int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        return gcd(num2, num1%num2);
    }
}