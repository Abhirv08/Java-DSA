class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            graph.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        // System.out.println(graph);
        int steps = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            steps++;
            
            for(int i = 0; i < sz; i++){
                int node = q.poll();
                
                if(node -1 >= 0 && graph.containsKey(arr[node - 1])){
                    q.add(node - 1);
                }

                if(node + 1 <  n && graph.containsKey(arr[node + 1])){
                    if(node + 1 == n - 1) return steps;
                    q.add(node + 1);
                }
                
                if(graph.containsKey(arr[node])){
                    for(int same: graph.get(arr[node])){
                        if(same != node){
                            if(same == n - 1) return steps;
                            q.add(same);
                        }
                    }
                }
                
                graph.remove(arr[node]);
            }
        }
        
        return steps;
    }
}