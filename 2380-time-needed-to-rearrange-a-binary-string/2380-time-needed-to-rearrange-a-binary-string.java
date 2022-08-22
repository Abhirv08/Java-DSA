class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int seconds = 0;
        int n = s.length();
        StringBuilder str = new StringBuilder(s);
        while(true){
            boolean flag = false;
            for(int i = 0; i < n - 1;){
                if(str.charAt(i) == '0' && str.charAt(i + 1) == '1'){
                    str.replace(i, i+1, "1");
                    str.replace(i+1, i + 2, "0");
                    flag = true;
                    i += 2;
                }else{
                    i++;
                }
            }
            
            if(!flag){
                break;
            }else{
                seconds++;
            }
        }
        
        
        return seconds;
    }
}