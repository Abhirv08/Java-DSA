class Solution {
    public int maximumUnits(int[][] bt, int truckSize) {
        Arrays.sort(bt, new Comparator<int[]> (){
             
            public int compare(int[] o1, int[] o2) {
                return (o1[1] - o2[1]) > 0 ? -1 : 1;
            }
        } );
        
        int ans = 0;
        
        int i = 0;
        
        while(truckSize > 0 && i < bt.length){
            int boxSize = Math.min(truckSize, bt[i][0]);
            truckSize -= boxSize;
            ans += boxSize*bt[i][1];
            i++;
        }
        
        return ans;
    }
}