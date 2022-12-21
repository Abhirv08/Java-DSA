class Solution {
    boolean overlapping;
    Set<Integer> list1;
    Set<Integer> list2;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = constructGraph(dislikes, n);
        overlapping = false;
        
        boolean[] vis = new boolean[n+1];
        list1 = new HashSet<>();
        list2 = new HashSet<>();
        
        boolean ans = true;
        for(int i = 1; i < n+1; i++){
            if(!vis[i]){
                list1.add(i);
                splitIntoTwo(adj, vis, 1, i);
            }
        }
        
        if(list1.size() + list2.size() == n){
            return true;
        }
        
        return false;
    }
    
    private void splitIntoTwo(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int list, int node){
        vis[node] = true;
        
        for(int notLiked: adj.get(node)){
            if(list == 1){
                list2.add(notLiked);
            }else{
                list1.add(notLiked);
            }
            if(!vis[notLiked]){
                splitIntoTwo(adj, vis, 1 - list, notLiked);
            }
        }
        
        return ;
    }
    
    private ArrayList<ArrayList<Integer>> constructGraph(int[][] dislikes, int n){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] dislike : dislikes){
            int a = dislike[0];
            int b = dislike[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        return adj;
    }
}