class MyCalendarThree {
    TreeMap<Integer, Integer> map;
    int maxEvent ;
    public MyCalendarThree() {
        map = new TreeMap<>();
        this.maxEvent = 0;
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int events = 0;
        
        for(int key: map.keySet()){
            events += map.get(key);
            
            maxEvent = Math.max(maxEvent, events);
        }
        
        return maxEvent;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */