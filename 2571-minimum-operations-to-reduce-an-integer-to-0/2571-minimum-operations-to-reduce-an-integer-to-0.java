class Solution {
    public int minOperations(int n) {
        int steps = 0;
        while(n > 0){
            int pow =(int) Math.round(Math.log(n)/Math.log(2));

            int diff = n - (int) Math.pow(2, pow);

            if(diff >= 0){
                n = n - (int) Math.pow(2, pow);
            }else{
                int pow2 = (int) Math.round(Math.log(-1*diff)/Math.log(2));
                n = n + (int) Math.pow(2, pow2);
            }
            steps++;
        }
        
        return steps;
    }
}