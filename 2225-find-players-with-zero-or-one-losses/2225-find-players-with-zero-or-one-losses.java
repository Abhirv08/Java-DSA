class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        TreeMap<Integer, Integer> losers = new TreeMap<>();
        TreeSet<Integer> winners = new TreeSet<>();
        
        for(int[] match: matches){
            losers.put(match[1], losers.getOrDefault(match[1], 0) + 1);
            winners.add(match[0]);
        }
        
        List<Integer> alwaysWinners = new ArrayList<>();
        for(int player: winners){
            if(!losers.containsKey(player)){
                alwaysWinners.add(player);
            }
        }
        
        List<Integer> singleTimeLosers = new ArrayList<>();
        for(int player: losers.keySet()){
            if(losers.get(player) == 1){
                singleTimeLosers.add(player);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(alwaysWinners);
        ans.add(singleTimeLosers);
        
        return ans;
    }
}