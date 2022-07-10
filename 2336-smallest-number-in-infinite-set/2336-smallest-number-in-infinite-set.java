class SmallestInfiniteSet {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    HashSet<Integer> set = new HashSet<>();
    
    public SmallestInfiniteSet() {
        for(int i = 1; i <= 1000; i++){
            pq.add(i);
            set.add(i);
        }
    }
    
    public int popSmallest() {
        if(pq.size() == 0){
            return -1;
        }
        set.remove(pq.peek());    
        return pq.poll();
    }
    
    public void addBack(int num) {        
        if(set.contains(num)){
            return; 
        }
        set.add(num);
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */