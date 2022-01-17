class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
    return check(a,b)||check(b,a);
    }
    static boolean check(String a, String b){
        int n = a.length();
        if(n==1){
            return true;
        }
        int l = 0;
        int r = n-1;
        while(l < r && a.charAt(l)==b.charAt(r)){
            l++;
            r--;
        }
        if(l>=r) return true;
        return isPalindrome(a.substring(l, r+1))||isPalindrome(b.substring(l, r+1));
    }

    static boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r && s.charAt(l)==s.charAt(r)){
            l++;
            r--;
        }
        if(l>=r) return true;
        return false;
    }
}