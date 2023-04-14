class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        
        List<String> list = new ArrayList<>();
        
        for(int i = m-1; i >= 0; i--){
            int n1 = num1.charAt(i) - '0';
            StringBuilder temp = new StringBuilder();
            int carry = 0;
            for(int j = n-1; j >= 0; j--){
                int n2 = num2.charAt(j) - '0';
                
                int sum = n1*n2 + carry;
                temp.append(sum%10);
                carry = sum/10;
            }
            if(carry > 0) temp.append(carry);
            list.add(temp.reverse().toString());
        }
        
        // System.out.println(list);
        
        StringBuilder ans = new StringBuilder(list.get(0));
        
        for(int i = 1; i < list.size(); i++){
            ans = getSum(ans, list.get(i), i);
        }
        
        int i = 0;
        while(i < ans.length() && ans.charAt(i) == '0'){
            i++;
        }
        
        if(i == ans.length()) return "0";
        
        return ans.toString();
    }
    
    private StringBuilder getSum(StringBuilder s1, String s2, int idx){
        int m = s1.length(), n = s2.length();
        int i = m - idx, j = n - 1;
        StringBuilder s = new StringBuilder(s1.substring(i));
        StringBuilder ans = new StringBuilder(s.reverse());
        i--;
        int carry = 0;
        while(i >= 0 && j >= 0){
            int n1 = s1.charAt(i) - '0';
            int n2 = s2.charAt(j) - '0';
            
            int sum = n1 + n2 + carry;
            ans.append(sum%10);
            carry = sum/10;
            i--; j--;
        }
        
        while(i >= 0){
            int n1 = s1.charAt(i) - '0';
            int sum = n1 + carry;
            ans.append(sum%10);
            carry = sum/10;
            i--;
        }
        
        while(j >= 0){
            int n2 = s2.charAt(j) - '0';
            int sum = n2 + carry;
            ans.append(sum%10);
            carry = sum/10;
            j--;
        }
        
        if(carry > 0) ans.append(carry);
        
        return ans.reverse();
    }
    
}