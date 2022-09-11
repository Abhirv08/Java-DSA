class Pair{
    int speed, efficiency;
    
    public Pair(int speed, int efficiency){
        this.speed = speed;
        this.efficiency = efficiency;
    }  
}

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Pair[] arr = new Pair[n];

        for(int i = 0; i < n; i++){
            arr[i] = new Pair(speed[i], efficiency[i]);
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.efficiency - o1.efficiency;
            }
        });

        // make min priorityQueue
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.speed - o2.speed;
            }
        });

        long ans = 0;
        long sumOfSpeeds = 0;

        for(int i = 0; i < n; i++){
            pq.offer(arr[i]);
            sumOfSpeeds += arr[i].speed;

            if(pq.size() > k){
                int speedOfPolled = pq.remove().speed;
                sumOfSpeeds -= speedOfPolled;
            }
               ans = Math.max(ans, (long)sumOfSpeeds*arr[i].efficiency);
        }

        return (int)(ans%1000000007);
    }
}