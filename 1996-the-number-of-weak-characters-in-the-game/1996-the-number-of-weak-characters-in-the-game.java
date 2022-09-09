class Solution {
    public int numberOfWeakCharacters(int[][] properties) {        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        
        for(int[] p : properties){
            pq.add(p);
        }
        int ans = 0;
        int max_defence = pq.peek()[1];
        int max_attack = pq.peek()[0];
        
        while(!pq.isEmpty()){
            int[] prop = pq.poll();
            
            if(prop[0] == max_attack){   // if attack of polled == attack of next
                max_defence = Math.max(max_defence, prop[1]);
                continue;
            }else{
                if(prop[1] < max_defence){   // if defence of popped < defence of next
                    ans++;
                }else{     // if defence of popped >= defence of next
                    max_defence = Math.max(max_defence, prop[1]);
                    continue;
                }
            }
            
        }
        
        return ans;
    }
}