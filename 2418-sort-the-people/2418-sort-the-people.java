class Pair implements Comparable<Pair>{
    String name;
    int height;
    
    public Pair(String name, int height){
        this.name = name;
        this.height = height;
    }
    
    public int compareTo(Pair p){
        return p.height - this.height;
    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        String[] ans = new String[names.length];
        for(int i = 0; i < names.length; i++){
            pq.add(new Pair(names[i], heights[i]));
        }
        
        for(int i = 0; i < names.length; i++){
            ans[i] = pq.poll().name;
        }
        
        return ans;
    }
}