class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        int totalGas = 0, totalCost = 0, currFuel = 0;
        int start = 0;
        for(int i = 0; i < n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            
            currFuel += gas[i] - cost[i];
            if(currFuel < 0){
                currFuel = 0;
                start = i + 1;
            }
        }
        
        return totalGas >= totalCost ? start : -1;
    }
}