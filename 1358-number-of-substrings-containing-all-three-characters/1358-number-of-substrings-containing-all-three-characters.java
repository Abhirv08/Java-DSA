class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int a = 0, b = 0, c = 0;
        
        int acq = 0, rel = 0;
        
        int ans = 0;
        while(acq < s.length()){
            char ch = s.charAt(acq);
            if(ch == 'a'){
                a++;
            }else if(ch == 'b'){
                b++;
            }else if(ch == 'c'){
                c++;
            }
            while(a > 0 && b > 0 && c > 0){
                ans += (n-acq);
                char rem = s.charAt(rel);
                if(rem == 'a'){
                    a--;
                }else if(rem == 'b'){
                    b--;
                }else if(rem == 'c'){
                    c--;
                }
                rel++;
            }
            acq++;
        }
        
        return ans;
    }
}