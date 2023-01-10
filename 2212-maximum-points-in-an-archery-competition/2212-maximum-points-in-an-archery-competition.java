class Solution {
    List<Integer> list;
    int score;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        list = new ArrayList<>();
        score = 0;
        findBobArrow(numArrows, aliceArrows, n - 1, new ArrayList<>(), 0);
        //System.out.println(list);
        int[] bob = new int[12];
        int total = 0;
        for(int idx: list){
            bob[idx] = aliceArrows[idx]+1;
            total += bob[idx];
        }
        if(numArrows - total > 0){
            bob[0] = numArrows - total;
        }
        return bob;
    }
    
    private void findBobArrow(int a, int[] aa, int idx, List<Integer> curr, int currScore){
        if(currScore > score){
            score = currScore; 
            list = new ArrayList<>(curr);
        }
        
        if(idx == 0) return ;
        
        // if Bob don't wants to get that score
        findBobArrow(a, aa, idx-1, curr, currScore);
        
        // if Bob want to get that score
        if(a > aa[idx]){
            curr.add(idx);
            findBobArrow(a - aa[idx] - 1, aa, idx-1, curr, currScore + idx);
            curr.remove(curr.size() - 1);
        }
        
        return ;
    }
}