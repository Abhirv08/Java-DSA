class Solution {
    public int binaryGap(int n) {
        if(Integer.bitCount(n) == 0 || Integer.bitCount(n) == 1 ){
            return 0;
        }
        return countAdjacentOnes( Integer.toBinaryString(n) );
    }
    
    static int countAdjacentOnes(String str){
        int maxDist = 0;
        int i = 0;
        int count = 0;
        int oneCounter = 0;
        while(i < str.length()){
            if(Integer.parseInt(String.valueOf(str.charAt(i))) == 1){
                oneCounter++;
            }
            if(oneCounter > 0 && oneCounter < 2){
                count ++;
                i++;
            }
            if(oneCounter == 2){
                oneCounter = 0;
                if(count > maxDist){
                    maxDist = count;
                }
                count = 0;
            }            
        }
        return maxDist;
    }
}