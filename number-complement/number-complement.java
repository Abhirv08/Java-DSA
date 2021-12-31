class Solution {
    public int findComplement(int num) {
        String str ="";
        while(num > 0){
            if((num&1) == 1){
                str = 0 + str;
            }else{
                str = 1+ str;
            }
           num= num >> 1;
        }
        return toDecimal(str);
    }
    
    static int toDecimal(String str){
        int num = 0;
        int count = 0;
        for(int i = str.length()-1; i>=0; i--){
            num += Integer.parseInt(String.valueOf(str.charAt(i)))*(int)Math.pow(2, count++ );
        }
        return num;
    }
}