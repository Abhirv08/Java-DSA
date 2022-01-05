class Solution {
    public int romanToInt(String s) {
        int num = 0;
        for(int i = s.length()-1; i >= 0; ){
             if(i>0 && romanToDecimalList(s.charAt(i-1)) < romanToDecimalList(s.charAt(i)) ){
                num += ( romanToDecimalList(s.charAt(i)) - romanToDecimalList(s.charAt(i-1)) ) ;
                i-=2;
            }else{
                num +=  romanToDecimalList(s.charAt(i));
                i--;
            } 
        }
        return num;
    }
    
    static int romanToDecimalList(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return -1;
    }
}