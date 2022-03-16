class Solution {
    public int minCostClimbingStairs(int[] cost) {
       return Math.min(helping(cost, new HashMap<Integer, Integer>(), 0),helping(cost, new HashMap<Integer, Integer>(), 1) ); 
    }
    
    static int helping(int[] cost, HashMap<Integer, Integer> map, int pointer){
        if(pointer == cost.length) return 0;
        if(pointer == cost.length+1) return 1001;
        
        int currentKey = pointer;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int price = cost[currentKey] + Math.min(helping(cost, map, currentKey+1), helping(cost, map, currentKey+2));
        
        if(!map.containsKey(currentKey)){
            map.put(currentKey, price);
        }
        
        return price;
    }
}