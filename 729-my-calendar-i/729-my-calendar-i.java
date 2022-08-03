class Pair implements Comparable<Pair>{
    int start, end;
    
    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    public int compareTo(Pair p){
        return this.start - p.start;
    }
}

class MyCalendar {
    ArrayList<Pair> events;
    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(events.size() == 0){
            events.add(new Pair(start, end));
            return true;
        }
        
        Collections.sort(events);
        
        for(Pair p : events){
            int s = p.start;
            int e = p.end;
            
            if(s < end && start < e){
                return false;
            }
        }
        
        events.add(new Pair(start, end)); 
        
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */