class MyCircularQueue {
    private int[] arr;
    private int removingIndex;
    private int addingIndex;
    private int k;
    private int lastItem;
    public MyCircularQueue(int k) {
        this.k = k;
        this.arr = new int[k];
        Arrays.fill(arr, -1);
        this.removingIndex = 0;
        this.addingIndex = 0;
        lastItem = 0;
    }
    
    public boolean enQueue(int value) {
        // check if it's full or not
        if(arr[addingIndex] != -1){
            return false;
        }
        
        // if it's not full
        arr[addingIndex] = value;
        lastItem = addingIndex;
        addingIndex = (addingIndex+1)%k;
        
        return true;
    }
    
    public boolean deQueue() {
        // is arr empty
        if(arr[removingIndex] == -1){
            return false;
        }
        
        // if not empty
        arr[removingIndex] = -1;
        removingIndex = (removingIndex+1)%k;
        
        return true;
    }
    
    public int Front() {
        return arr[removingIndex];
    }
    
    public int Rear() {
        return arr[lastItem];
    }
    
    public boolean isEmpty() {
        return arr[removingIndex] == -1;
    }
    
    public boolean isFull() {
        return arr[addingIndex] != -1;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */