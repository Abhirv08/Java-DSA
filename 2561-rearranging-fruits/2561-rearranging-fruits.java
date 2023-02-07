class Solution {
    public long minCost(int[] b1, int[] b2) {
        int n = b1.length;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int minVal = b1[0];
        
        for(int i = 0; i < n; i++){
            map1.put(b1[i], map1.getOrDefault(b1[i], 0) + 1);
            map2.put(b2[i], map2.getOrDefault(b2[i], 0) + 1);
            minVal = Math.min(minVal, b1[i]);
            minVal = Math.min(minVal, b2[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int key: map1.keySet()){
            int f1 = map1.get(key);
            int f2 = map2.getOrDefault(key, 0);
            
            if((f1+f2)%2 == 1) return -1;
            
            int diff = Math.abs(f1 - f2)/2;
            while(diff-- > 0){
                list.add(key);
            }
            map1.put(key, 0);
            if(map2.containsKey(key)) map2.put(key, 0);
        }
        
        for(int key: map2.keySet()){
            int f = map2.get(key);
            
            if(f%2 == 1) return -1;
            
            int diff = f/2;
            while(diff-- > 0){
                list.add(key);
            }
            map2.put(key, 0);
        }
        
        Collections.sort(list);
        
        long ans = 0;
        for(int i = 0; i < list.size()/2; i++){
            ans += Math.min(2l*minVal, 1l*list.get(i));
        }
        
        return ans;        
    }
}