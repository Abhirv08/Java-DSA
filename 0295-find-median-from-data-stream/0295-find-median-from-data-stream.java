class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int i = 0, j = list.size() - 1;
        
        while(i <= j){
            int mid = i + (j - i)/2;
            
            if(list.get(mid) == num){
                list.add(mid, num);
                return;
            }else if(list.get(mid) > num){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        
        list.add(i, num);
        return;
    }
    
    public double findMedian() {
        double ans = 0;
        int n = list.size();
        
        if(n%2 == 1){
            return (double)list.get((n+1)/2 - 1);
        }
        
        int num1 = list.get(n/2 - 1);
        int num2 = list.get(n/2);
        
        return (double)(num1 + num2)/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */