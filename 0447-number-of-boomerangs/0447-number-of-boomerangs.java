class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        HashMap<Double, Integer> map = new HashMap<>();
        
        long ways = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                int delx = points[i][0] - points[j][0];
                int dely = points[i][1] - points[j][1];
                
                double dist = Math.sqrt(delx*delx + dely*dely);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            
            for(double key: map.keySet()){
                int fq = map.get(key);
                ways += fq*(fq-1);
            }
            map.clear();
        }
        
        
        //System.out.println(map);
        
        
        return (int)ways;        
    }
}