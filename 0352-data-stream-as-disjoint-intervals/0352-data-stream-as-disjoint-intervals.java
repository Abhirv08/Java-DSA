class SummaryRanges {
    TreeSet<Integer> set;
    public SummaryRanges() {
        set = new TreeSet<>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals(){
        if(set.isEmpty()){
            return new int[0][2];
        }
        List<int[]> list = new ArrayList<>();
        
        int start = -1, end = -1;
        for(int value: set){
            if(start == -1){
                start = value;
                end = value;
            }else{
                if(value == end + 1) end = value;
                else{
                    list.add(new int[]{start, end});
                    start = value;
                    end = value;
                }
            }            
        }
        list.add(new int[]{start, end});
        
        return list.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */