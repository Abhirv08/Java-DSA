class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int acq = 0, rel = 0;
        int ans = 0;
        while(acq < fruits.length){
            map.put(fruits[acq], map.getOrDefault(fruits[acq], 0) + 1);
            if(map.size() > 2){
                while(map.size() > 2){
                    map.put(fruits[rel], map.get(fruits[rel])- 1);
                    if(map.get(fruits[rel]) == 0) map.remove(fruits[rel]);
                    rel++;
                }
            }
            ans = Math.max(ans, findNumber(map));
            acq++;
        }
        
        return ans;
    }
    
    int findNumber(HashMap<Integer, Integer> map){
        int ans = 0;
        for(int key: map.keySet()){
            ans += map.get(key);
        }
        
        return ans;
    }
}