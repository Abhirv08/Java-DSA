class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        q.add(start);
        
        Set<String> seen = new HashSet<>();
        seen.add(start);
        
        int steps = 0;
        while(!q.isEmpty()){
            int n = q.size();
            while(n-- > 0){
                String node = q.poll();
                if(node.equals(end)) return steps;
                
                for(char ch: new char[]{'A', 'C', 'G', 'T'}){
                    for(int i = 0; i < 8; i++){
                        String neighbour = node.substring(0, i) + ch + node.substring(i+1);
                        if(!seen.contains(neighbour) && Arrays.asList(bank).contains(neighbour)){
                            q.add(neighbour);
                            seen.add(neighbour);
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}