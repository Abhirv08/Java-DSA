class Solution {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        
        for(char ch: secret.toCharArray()){
            nums[ch - '0']++;
        }
        
        int bulls = 0, cows = 0;
        
        for(int i = 0; i < secret.length(); i++){
            int num = guess.charAt(i) - '0';
            if(nums[num] > 0 && guess.charAt(i) == secret.charAt(i)){
                bulls++;
                nums[num]--;
            }
        }
        
        for(int i = 0; i < secret.length(); i++){
            int num = guess.charAt(i) - '0';
            if(guess.charAt(i) == secret.charAt(i)){
                continue;
            }
            if(nums[num] > 0){
                cows++;
                nums[num]--;
            }
        }
        
        String ans = bulls + "A" + cows + "B";
        
        return ans;
    }
}