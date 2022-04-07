class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        Arrays.sort(stones);
        int y = stones[stones.length-1];
        int x = stones[stones.length-2];
        while(x > 0 && y > 0){
            stones[stones.length-2] = 0;
            stones[stones.length-1] = y-x;
            Arrays.sort(stones);
            y = stones[stones.length-1];
            x = stones[stones.length-2];
        }
        return stones[stones.length-1];
    }
}