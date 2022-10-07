class MyCalendarTwo {
    private ArrayList<int[]> events;
    private ArrayList<int[]> doubleBooking;
    public MyCalendarTwo() {
        this.events = new ArrayList<>();
        this.doubleBooking = new ArrayList<>();

    }
    
    public boolean book(int start, int end) {
        for(int[] e: doubleBooking){
            if(start < e[1] && end > e[0]){
                return false;
            }
        }
        
        for(int[] e: events){
            // if there is double booking
            if(start < e[1] && end > e[0]){
                doubleBooking.add(new int[]{Math.max(start, e[0]), Math.min(end, e[1])});
            }            
        }
        
        events.add(new int[]{start, end});
        
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */