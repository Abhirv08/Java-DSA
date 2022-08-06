class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int trial = minutesToTest / minutesToDie;
        
        return (int)Math.ceil(Math.log(buckets)/Math.log(trial + 1));
    }
}