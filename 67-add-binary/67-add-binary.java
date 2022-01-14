class Solution {
    static String addBinary(String a, String b) {
        if(a.length() < b.length()){
            String temp = b;
            b = a;
            a = temp;
        }
        int m = a.length();
        int n = b.length();
        int carry = 0;
        int i = n-1;
        String ans = "";
        while (i >= 0) {
            String p = a.substring(m-1, m);
            String q = b.substring(i, i+1);
            if(p.equals("1") && q.equals("1")){
                if (a.length()==b.length() && i == 0){
                    if (carry == 1){
                        ans = 11 + ans;
                    }else{
                        ans = 10 + ans;
                    }
                }else{
                    if (carry==1){
                        ans = 1 + ans;
                        carry = 1;
                    }else{
                        ans = 0 + ans;
                        carry = 1;
                    }
                }
            }else if(p.equals("0")&&q.equals("0")){
                ans = (0+carry) + ans;
                carry = 0;
            }else{
                if (carry == 1){
                    ans = 0 + ans;
                    carry = 1;
                }else{
                    ans = 1 + ans;
                }
            }
            i--;m--;
        }
        int j  = a.length()-n;
        i = a.length() - n - 1;
        while (j>0){
            String p = a.substring(i, i+1);
            if (i==0){
                if (carry==1){
                    ans = 10 + ans;
                }else{
                    ans = 1 + ans;
                }
            }else{
                if (carry==1){
                    if (p.equals("1")){
                        ans = 0 + ans;
                        carry = 1;
                    }else{
                        ans = 1 + ans;
                        carry = 0;
                    }
                }else{
                    ans = p + ans;
                }
            }
            i--;j--;
        }

        return ans;
    }

    
}