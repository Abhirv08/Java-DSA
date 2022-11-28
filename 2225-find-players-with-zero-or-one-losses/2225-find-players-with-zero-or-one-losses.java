class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] players = new int[100001];
        Arrays.fill(players, -1);
        
        for(int[] match: matches){
            int loser = match[1];
            int winner = match[0];
            
            if(players[winner] == -1){
                players[winner]++;
            }
                
            if(players[loser] == -1){
                players[loser] = 1;
            }else{
                players[loser]++;
            }
        }
        
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());list.add(new ArrayList<>());
        
        for(int i = 0; i < 100001; i++){
            if(players[i] == 0){
                list.get(0).add(i);
            }else if(players[i] == 1){
                list.get(1).add(i);
            }
        }
        
        return list;
    }
}