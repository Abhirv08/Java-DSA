class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> memo = new HashMap<>();
        int i = 0;
        long dayNo = 1;
        while(i < tasks.length){
            
            if(memo.containsKey(tasks[i])){
                long dayShouldBe = memo.get(tasks[i]) + space + 1;
                
                long breakDays = dayShouldBe - dayNo;
                if(breakDays > 0){
                    dayNo = dayShouldBe; 
                }
                                        
            }
            memo.put(tasks[i], dayNo);            
            dayNo++;
            i++;
        }
        
        return dayNo - 1;
    }
}