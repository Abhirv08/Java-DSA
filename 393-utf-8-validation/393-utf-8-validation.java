class Solution {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        
        String[] binary = new String[n];
        
        for(int i = 0; i < n; i++){
            StringBuilder s = new StringBuilder();
            int num = data[i];
            s.append(Integer.toString(num, 2));

            binary[i] = s.toString();
        }

        for(int i = 0; i < n; ){
            int bytes = getBytes(binary[i]);
            
            if(bytes == 1 || bytes > 4){
                return false;
            }else if(bytes > 1){
                i++;
            }

            boolean increased = false;
            while(bytes > 1 && i < n){
                int ones = getBytes(binary[i]);
                if(ones != 1){
                    return false;
                }
                bytes--;
                i++;
                increased = true;
            }

            if(bytes != 1 && i == n){
                return false;
            }

            if(!increased){
                i++;
            }
        }
        
        return true;
    }
    
    private int getBytes(String s){
        if(s.length() < 8){
            return 0;
        }
        
        int ones = 0;
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '0'){
                return ones;
            }
            
            ones++;
            i++;
        }
        
        return ones;
    }
    
}