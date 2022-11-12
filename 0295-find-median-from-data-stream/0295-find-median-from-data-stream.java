class MedianFinder {
    PriorityQueue<Integer> lf;
    PriorityQueue<Integer> uf;
    public MedianFinder() {
        lf =  new PriorityQueue<>((a, b) -> b - a);
        uf =  new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(lf.isEmpty() || num <= lf.peek()){
            lf.add(num);
        }else{
            uf.add(num);
        }
        
        if(lf.size() < uf.size()){
            lf.add(uf.poll());
        }else if(lf.size() > uf.size() + 1){
            uf.add(lf.poll());           
        }
    }
    
    public double findMedian() {
        if(lf.size() == uf.size()){
            return (double)(lf.peek() + uf.peek())/2;
        }
        
        return (double)lf.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */