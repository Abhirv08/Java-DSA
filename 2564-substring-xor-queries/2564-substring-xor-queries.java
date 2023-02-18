class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = queries.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < n; i++){
            int[] q = queries[i];
            map.putIfAbsent(q[0]^q[1], new ArrayList<>());
            map.get(q[0]^q[1]).add(i);
            max = Math.max(max,q[0]^q[1]);
        }
        
        int[][] ans = new int[n][2];
        for(int[] row: ans) Arrays.fill(row, -1);
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                if(map.containsKey(0)){
                    updateAns(ans, map.get(0), i, i);
                }
                map.remove(0);
                continue;
            }
            
            int val = 0;
            for(int j = i; j < Math.min(i+30, s.length()); j++){
                val = (val << 1) + (s.charAt(j) - '0');
                if(val > max) break;
                if(map.containsKey(val)){
                    updateAns(ans, map.get(val), i, j);
                    map.remove(val);
                }
            }
        }
        
        return ans;
    }
    
    void updateAns(int[][] ans, List<Integer> list, int left, int right){
        for(int idx: list){
            ans[idx][0] = left;
            ans[idx][1] = right;
        }
    }
}