class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = queries.length;
            HashMap<Integer, int[]> map = new HashMap<>();

            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    if(!map.containsKey(0)) map.put(0, new int[]{i, i});
                    continue;
                }
                for(int j = i; j < Math.min(i+30, s.length()); j++){
                    int num = Integer.parseInt(s.substring(i, j+1), 2);
                    if(!map.containsKey(num)){
                        map.put(num, new int[]{i, j});
                    }
                }
            }

            int[][] ans = new int[n][2];
            for(int[] row: ans) Arrays.fill(row, -1);

            for(int i = 0; i < n; i++){
                int[] q = queries[i];
                int key = q[0]^q[1];
                if (map.containsKey(key)){
                    ans[i] = map.get(key);
                }
            }

            return ans;
    }
}