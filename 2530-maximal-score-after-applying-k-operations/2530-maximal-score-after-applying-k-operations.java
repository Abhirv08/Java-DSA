class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int num: nums){
            pq.add(num);
        }
        
        //System.out.println(pq);
        
        long ans = 0;
        while(k-- > 0){
            int num = pq.poll();
            
            int q = num/3;
            int rem = num%3;
            
            ans += num;
            if(rem == 0){
                pq.add(q);
            }else{
                pq.add(q+1);
            }
        }
        
        return ans;
    }
}