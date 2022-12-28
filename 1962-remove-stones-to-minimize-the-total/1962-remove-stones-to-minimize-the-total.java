class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int pile: piles){
            pq.add(pile);
        }
        
        while(k-- > 0){
            int max = pq.poll();
            pq.add(max - max/2);
        }
        
        int ans = 0;
        while(!pq.isEmpty()){
            ans += pq.poll();
        }
        
        return ans;
    }
}