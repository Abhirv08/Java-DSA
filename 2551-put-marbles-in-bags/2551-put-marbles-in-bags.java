class Solution {
    public long putMarbles(int[] w, int k) {
        int n = w.length;
        if(k == n || k == 1) return 0;
        
        List<Long> list = new ArrayList<>();
        
        for(int i = 1; i < n; i++){
            long sum = w[i-1] + w[i];
            list.add(sum);            
        }
        long min = w[0] + w[n-1];
        long max = w[0] + w[n-1];
        
        Collections.sort(list);
        for(int i = 0; i < k-1; i++){
            min += list.get(i);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        for(int i = 0; i < k-1; i++){
            max += list.get(i);
        }
        
        return max - min;
    }
}