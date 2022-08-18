class Pair implements Comparable<Pair>{
    int num, occurances;
    
    Pair(int num, int occurances){
        this.num = num;
        this.occurances = occurances;
    }
    
    public int compareTo(Pair p){
        return p.occurances - this.occurances;
    }
    
}
class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Pair[] nums = new Pair[map.size()];
        
        int i = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            nums[i] = new Pair(e.getKey(), e.getValue());
            i++;
        }
        
        Arrays.sort(nums);
        
        int ans = 0;
        i = 0;
        while(i < arr.length && len > arr.length/2){
            ans++;
            len -= nums[i].occurances;
            i++;
        }
        
        return ans;
    }
}