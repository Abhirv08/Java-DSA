class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        findAllPath(graph.length, graph, 0, list);
        
        return ans;
    }
    
    private void findAllPath(int n, int[][] graph, int currNode, List<Integer> list){
        if(currNode == n - 1){
            ans.add(new ArrayList<>(list));
            return ;
        }
        
        for(int neigh: graph[currNode]){
            list.add(neigh);
            findAllPath(n, graph, neigh, list);
            list.remove(list.size() - 1);
        }
        
        return ;
    }
}