class Solution {
    public int tribonacci(int n) {
        return helping(n, new HashMap<Integer, Integer>());
    }
    
    private int helping(int n, HashMap<Integer, Integer> map){
        if(n==0) return 0;
        if(n <= 2) return 1;
        
        int currentKey = n;
        
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int num = helping(n-1, map) + helping(n-2, map) + helping(n-3, map);
        
        map.put(currentKey, num);
        
        return num;
    }
}