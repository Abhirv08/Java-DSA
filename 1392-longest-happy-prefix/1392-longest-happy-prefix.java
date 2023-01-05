class Solution {
    public String longestPrefix(String s) {
        long p = 31;
        long pow = 1;
        int mod = 1000000007;
        
        long pref = 0, suff = 0;
        String ans = "";
        int n = s.length();
        for(int i = 0; i < n-1; i++){
            pref = ((pref*p)%mod + (s.charAt(i) - 'a' + 1))%mod;
            suff = (suff + ((long)(s.charAt(n-1-i) - 'a' + 1)*pow)%mod)%mod;
            pow = (pow*p)%mod;
            if(pref == suff && ans.length() < i+1) ans = s.substring(0, i+1);
        }
        
        return ans;
    }
}