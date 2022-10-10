class Solution {
    public String breakPalindrome(String palindrome) {
        
        int n = palindrome.length();
        if(n == 1){
            return "";
        }
        
        StringBuilder ans = new StringBuilder(palindrome);
        if(n == 2){
            if(ans.charAt(n-1) == 'a'){
                return "ab";
            }else{
                ans.replace(0, 1, "a");                
                return ans.toString();
            }
        }
        
        int left = 0, right = n - 1;
        
        while(left < right){
            if(ans.charAt(left) != 'a'){
                ans.replace(left, left+1, "a");                
                return ans.toString();
            }
            left++;
            right--;
        }
        
        if(left == right){
            ans.replace(n - 1, n, "b"); 
        }
        return ans.toString();
    }
}