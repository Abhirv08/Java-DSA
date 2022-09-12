class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        // tokens = [100, 200, 300, 400]
        int score = 0;
        int maxScore = 0;
        int i = 0;
        int j = tokens.length - 1;
        
        while(i <= j){
            if(power < tokens[i]){  // not enough power to buy tokens
                if(score == 0){
                    break;
                }else{
                    power += tokens[j];
                    j--;
                    score--;
                }
            }else{
                power -= tokens[i];
                score++;
                i++;
            } 
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }
}