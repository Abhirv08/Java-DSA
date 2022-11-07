class Solution {
    public int maximum69Number (int num) {
        String str = Integer.toString(num);
        
        int[] chars = new int[str.length()];
        
        int i = str.length() - 1;
        while(num > 0){
            chars[i] = num%10;
            num /= 10;
            i--;
        }
        
        for(i = 0; i < chars.length; i++){
            if(chars[i] == 6){
                chars[i] = 9;
                break;
            }
        }
        
        int ans = 0;
        
        for(i = 0; i < chars.length; i++){
            ans += Math.pow(10, chars.length - 1 - i)*chars[i];
        }
        
        return ans;
    }
}