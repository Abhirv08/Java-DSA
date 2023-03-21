class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        //int clothes = Arrays.stream(machines).sum();
        int clothes = 0;
        for(int num: machines) clothes += num;
        
        if(clothes % n != 0) return -1;
        
        int req = clothes/n;
        int clothes_so_far = 0, max = 0;
        
        for(int pres: machines){
            clothes_so_far += pres - req;
            
            max = Math.max(max, Math.abs(clothes_so_far));
            max = Math.max(max, pres - req);
        }
        
        return max;
    }
}