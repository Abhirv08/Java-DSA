class Triplet implements Comparable<Triplet>{
    int start, end, profit;
    
    public Triplet(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
    
    public int compareTo(Triplet T){
        return this.start == T.start ? this.end - T.end : this.start - T.start;
    }
}
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int maxEndTime = 0;
        Triplet[] jobs = new Triplet[n];
        
        for(int i = 0; i < n; i++){
            jobs[i] = new Triplet(startTime[i], endTime[i], profit[i]);
            maxEndTime = Math.max(maxEndTime, endTime[i]);
        }
        
        Arrays.sort(jobs);
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return findMaxProfit(jobs, 0, dp);
    }
    
    private int findMaxProfit(Triplet[] jobs, int idx, int[] dp){
        if(idx == jobs.length){
            return 0;
        }
        
        if(dp[idx] != -1) return dp[idx];
        
        
        int ifTaken = jobs[idx].profit;
        int nextIdx = nextIndex(jobs, idx);
        if(nextIdx != -1){
            ifTaken += findMaxProfit(jobs, nextIdx, dp);
        }        
        int ifNotTaken = findMaxProfit(jobs, idx+1, dp);
        
        return dp[idx] = Math.max(ifTaken, ifNotTaken);
    }
    
    private int nextIndex(Triplet[] jobs, int index){
        int start = index+1, end = jobs.length-1, ans = -1;
        while(start<=end) {
            int mid = (start+end)>>1;
            if(jobs[index].end <= jobs[mid].start) {
                ans = mid;
                end = mid-1;
            } else start = mid+1;
        }
        return ans;
    }
    
}