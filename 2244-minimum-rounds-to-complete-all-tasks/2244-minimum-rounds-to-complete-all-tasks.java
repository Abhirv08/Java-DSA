class Solution {
    public int minimumRounds(int[] tasks) {
        if(tasks.length == 1) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int task: tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        
        int ans = 0;
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(freq == 1) return -1;
            
            ans += freq/3;
            freq %= 3;
            if(freq > 0){
                ans++;
            }
        }
        
        return ans;
    }
}