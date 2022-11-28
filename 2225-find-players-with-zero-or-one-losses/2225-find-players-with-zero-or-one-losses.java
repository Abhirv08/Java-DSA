class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        HashMap<Integer, Integer> losers = new HashMap<>();
        HashMap<Integer, Integer> winners = new HashMap<>();
        
        for(int[] match: matches){
            losers.put(match[1], losers.getOrDefault(match[1], 0) + 1);
            winners.put(match[0], winners.getOrDefault(match[0], 0) + 1);
        }
        
        List<Integer> alwaysWinners = new ArrayList<>();
        for(int player: winners.keySet()){
            if(!losers.containsKey(player)){
                alwaysWinners.add(player);
            }
        }
        
        Collections.sort(alwaysWinners);
        
        List<Integer> singleTimeLosers = new ArrayList<>();
        for(int player: losers.keySet()){
            if(losers.get(player) == 1){
                singleTimeLosers.add(player);
            }
        }
        
        Collections.sort(singleTimeLosers);
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(alwaysWinners);
        ans.add(singleTimeLosers);
        
        return ans;
    }
}