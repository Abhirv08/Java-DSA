class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int num1 = tops[0];
        int num2 = bottoms[0];
        int[] count = new int[4];
        count[0] = dominoRotationForTop(tops, bottoms, num1);        
        count[1] = dominoRotationForBottom(tops, bottoms, num1);        
        count[2] = dominoRotationForTop(tops, bottoms, num2);        
        count[3] = dominoRotationForBottom(tops, bottoms, num2);
        int ans = count[0];
        for(int i = 1; i < 4; i++){
            ans = Math.min(ans, count[i]);
        }
        if(ans == 200000){
            return -1;
        }
        return ans;
    }
    
    static int dominoRotationForTop(int[] tops, int[] bottoms, int num){
        int counter = 0;
        for(int i = 0; i < tops.length; i++){
            if(tops[i] != num && bottoms[i] != num) return 200000;
            if(tops[i] != num){
                counter++;
            }
        }
        return counter;
    }
    
    static int dominoRotationForBottom(int[] tops, int[] bottoms, int num){
        int counter = 0;
        for(int i = 0; i < tops.length; i++){
            if(tops[i] != num && bottoms[i] != num) return 200000;
            if(bottoms[i] != num){
                counter++;
            }
        }
        return counter;
    }
}