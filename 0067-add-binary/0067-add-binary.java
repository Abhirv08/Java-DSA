class Solution {
    static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int rem = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 && j >= 0) {
            if(a.charAt(i) == '1' && b.charAt(j) == '1'){
                if(rem == 1){
                    result.append("1");
                }else{
                    result.append("0");
                }
                rem = 1;
            }else if((a.charAt(i) == '0' && b.charAt(j) == '1') || (a.charAt(i) == '1' && b.charAt(j) == '0')){
                if(rem == 1){
                    result.append("0");
                }else{
                    result.append("1");
                }
            }else{
                if(rem == 1){
                    result.append("1");
                    rem = 0;
                }else{
                    result.append("0");
                }
            }
            i--;
            j--;
        }
        
        while(i >= 0){
            if(a.charAt(i) == '1'){
                if(rem == 1){
                    result.append("0");
                }else{
                    result.append("1");
                }
            }else{
                if(rem == 0){
                    result.append("0");
                }else{
                    result.append("1");
                    rem = 0;
                }
            }
            i--;
        }
        
        while(j >= 0){
            if(b.charAt(j) == '1'){
                if(rem == 1){
                    result.append("0");
                }else{
                    result.append("1");
                }
            }else{
                if(rem == 0){
                    result.append("0");
                }else{
                    result.append("1");
                    rem = 0;
                }
            }
            j--;
        }
        
        if (rem == 1) {
            result.append(rem);
        }
        return result.reverse().toString();
    }

    
}