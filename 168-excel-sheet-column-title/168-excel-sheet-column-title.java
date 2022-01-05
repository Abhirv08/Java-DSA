class Solution {
    public String convertToTitle(int n) {
       String s ="";
        int na=n;
        while(n>=27){
            na=n;
            na=na%26;
            if(na==0){
                s=s+'z';
                n=n-1;
            }else{
            s=s+(char)(na+96); 
            }
                n=n/26;
        }
        
        s=s+(char)(n+96);
        
        return new StringBuilder(s.toUpperCase()).reverse().toString();
    }
}