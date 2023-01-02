class Solution {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        
        int bulls = 0, cows = 0;
        
        for(int i = 0; i < secret.length(); i++){
            int num = guess.charAt(i) - '0';
            if(guess.charAt(i) == secret.charAt(i)){
                bulls++;
            }else{                
                nums[secret.charAt(i) - '0']++;
            }
        }
        
        for(int i = 0; i < secret.length(); i++){
            int num = guess.charAt(i) - '0';
            if(guess.charAt(i) != secret.charAt(i) && nums[num] > 0){
                cows++;
                nums[num]--;
            }
        }
        
        String ans = bulls + "A" + cows + "B";
        
        return ans;
    }
}