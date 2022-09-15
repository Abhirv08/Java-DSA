class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 == 1) return new int[0];
        
        Arrays.sort(changed);      // O(nlogn)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : changed){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int num: changed){
            if(map.containsKey(num)){
                if(num == 0){
                    int freq = map.get(0);
                    if(freq >= 2){
                        list.add(0);
                        map.put(0, map.get(0)-2);
                    }else{
                        map.remove(0);
                    }                
                }else{
                    if(map.containsKey(2*num)){
                        list.add(num);
                        map.put(num, map.get(num)-1);
                        if(map.get(num) == 0){
                            map.remove(num);
                        }
                        map.put(2*num, map.get(2*num)-1);
                        if(map.get(2*num) == 0){
                            map.remove(2*num);
                        }
                    }else{
                        map.remove(num);
                    }
                }
            }            
        }
        
        int[] ans = new int[list.size()];
        
        int i = 0;
        for(int num: list){
            ans[i] = num;
            i++;
        }
        
        return list.size()*2 == changed.length ? ans : new int[0];
    }
}