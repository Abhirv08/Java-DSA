class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        if(n==1){
            return cost[0];
        }
        if(n==2){
            return cost[0]+cost[1];
        }
        Arrays.sort(cost);
        int sum = 0;        
        for(int i = n-1; i>=0; i-=3){
            if(i>=1){
                sum += (cost[i]+cost[i-1]);
            }else {
                sum += cost[i];
            }
            
        }
        return sum;
    }
}